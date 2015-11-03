package com.funguide.funshopping.base;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;


/**
 * Created by yangshuai on 2015/10/14 0014 16:58.
 * 
 * A simple {@link android.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BaseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener{

    public String FragmentTitle = "BaseFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    protected static final String ARG_PARAM1 = "param1";
    protected static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    protected String mParam1;
    protected String mParam2;

    protected OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Fresco.initialize(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private Toast toast = null;
    protected void showToast(String message) {
        if (toast == null) {
            toast = Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT);
        }else{
            toast.setText(message);
        }
        toast.show();
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
        public void onFragmentInteraction(String message);
        public void onFragmentChildViewOnClick(View view);
    }


    private boolean isFragmentSelected;
    private boolean isFirst = true;
    /**
     * 当Fragment选中时
     */
    public void setFragmentSeleted(boolean selected) {
        isFragmentSelected = selected;
        if (isFragmentSelected) {
            if (isFirst) {
                onFragmentSeleted(true);
                isFirst = false;
            } else {
                onFragmentSeleted(false);
            }

        } else {
            onFragmentUnSeleted();
        }

    }

    /**
     * 当Fragment切换为选中时
     */
    protected abstract void onFragmentSeleted(boolean isFirst);

    /**
     * 当Fragment切换为未选中时
     */
    protected abstract void onFragmentUnSeleted();

}
