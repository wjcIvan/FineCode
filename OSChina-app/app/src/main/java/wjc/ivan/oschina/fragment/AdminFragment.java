package wjc.ivan.oschina.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import wjc.ivan.oschina.R;
import wjc.ivan.oschina.activity.DetailActivity;
import wjc.ivan.oschina.activity.LoginActivity;
import wjc.ivan.oschina.activity.MainActivity;

/**
 * Created by 龙心诚 on 2018/6/26 0026.
 */

public class AdminFragment extends Fragment {

    private ImageView imgUser;
    public static TextView tvUserName;
    public static String Name;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_admin,container,false);
        imgUser= (ImageView) view.findViewById(R.id.imgUser);
        tvUserName= (TextView) view.findViewById(R.id.tvUserName);
        if (Name!=null)
            tvUserName.setText(Name);
        //Log.i("tvUserName1","111");
        imgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tvUserName",tvUserName.getText().toString());
                if (tvUserName.getText().toString().equals("未登录")){
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }else{
                    /*DialogFragment dialogFragment=new DialogFragment();
                    dialogFragment.set
                    tvUserName.setText("");*/
                    /*AlertDialog.Builder alertDialog=new AlertDialog.Builder(getContext());
                    alertDialog.setMessage("退出登录？").setCancelable(true).show();*/
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    //builder.setIcon(R.drawable.icon);
                    //builder.setTitle("Title");
                    builder.setMessage("登出？");
                    builder.setPositiveButton("确定",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Toast.makeText(getActivity(),"已退出登录",Toast.LENGTH_SHORT).show();
                                    tvUserName.setText("未登录");
                                    //Log.i("11","点击了对话框上的Button1");
                                }
                            });
                    builder.setNeutralButton("取消",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    //Log.i("22","点击了对话框上的Button1");
                                }
                            });
                    builder.show();

                }
            }
        });




        return view;
    }
}
