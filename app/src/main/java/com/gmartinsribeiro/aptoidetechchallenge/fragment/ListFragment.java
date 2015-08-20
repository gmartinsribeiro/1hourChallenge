package com.gmartinsribeiro.aptoidetechchallenge.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmartinsribeiro.aptoidetechchallenge.R;
import com.gmartinsribeiro.aptoidetechchallenge.adapter.ListAdapter;
import com.gmartinsribeiro.aptoidetechchallenge.controller.AptoideAPI;
import com.gmartinsribeiro.aptoidetechchallenge.entity.AptoideResponse;
import com.gmartinsribeiro.aptoidetechchallenge.utility.Connectivity;
import com.gmartinsribeiro.aptoidetechchallenge.utility.Constants;
import com.gmartinsribeiro.aptoidetechchallenge.utility.DialogUtils;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Gonçalo Martins Ribeiro on 20-08-2015.
 */
public class ListFragment extends Fragment {

    private static final String TAG = "ListFragment";

    private RecyclerView mList;
    private ListAdapter mAdapter;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        mList = (RecyclerView) v.findViewById(R.id.list);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Check connection
        if (!Connectivity.isConnected(getActivity())) {
            DialogUtils.createNetErrorDialog(getActivity());
        } else {
            getDataFromServer();
        }
    }

    private void getDataFromServer() {
        //Retrofit section start from here...
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.API_URL).build();         //creating an adapter for retrofit with base url

        AptoideAPI controller = restAdapter.create(AptoideAPI.class);    //creating a service for adapter with our GET class

        try{
            //Retrofit using gson for JSON-POJO conversion
            controller.getAllApps(new Callback<AptoideResponse>() {
                @Override
                public void success(AptoideResponse aptoideResponse, Response response) {

                    if(aptoideResponse.getResponses() != null && aptoideResponse.getResponses().getListApps() != null && aptoideResponse.getResponses().getListApps().getDatasets() != null && aptoideResponse.getResponses().getListApps().getDatasets().getAll() != null && aptoideResponse.getResponses().getListApps().getDatasets().getAll().getData() != null){
                        mAdapter = new ListAdapter(getActivity(), aptoideResponse.getResponses().getListApps().getDatasets().getAll().getData().getList());

                        mList.setAdapter(mAdapter);

                        // Setup layout manager for items
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        layoutManager.scrollToPosition(0);

                        // Attach layout manager to the RecyclerView
                        mList.setLayoutManager(layoutManager);
                    }else{
                        DialogUtils.createApiErrorDialog(getActivity());
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.e(TAG, error.getMessage());
                    // Show user dialog
                    DialogUtils.createApiErrorDialog(getActivity());
                }
            });
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
            //Show user dialog
            DialogUtils.createInternalErrorDialog(getActivity());
        }
    }
}
