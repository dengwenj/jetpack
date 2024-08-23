package vip.dengwj.myjetpack.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import vip.dengwj.myjetpack.R;
import vip.dengwj.myjetpack.databinding.TestDataFragmentBinding;
import vip.dengwj.myjetpack.domain.User;

public class TestDataFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TestDataFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.test_data_fragment, container, false);

        // 要赋值！！！！
        binding.setUser(new User("朴睦", 24, "男"));
        binding.setTestData(new HandlerEvent());
        return binding.getRoot();
    }

    public class HandlerEvent {
        public void handleClick(View view) {
            Log.d("pumu", "view -> " + view);
        }
    }
}
