package wjc.ivan.oschina.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;


import okhttp3.Headers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import wjc.ivan.oschina.R;
import wjc.ivan.oschina.bean.LoginBean;
import wjc.ivan.oschina.fragment.AdminFragment;
import wjc.ivan.oschina.utils.XmlUtils;

import static android.Manifest.permission.READ_CONTACTS;
import static wjc.ivan.oschina.R.id.tvloginName;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity{

    // UI references.
    private AutoCompleteTextView mTvLoginName;
    private EditText mTvPassword;
    private Button email_sign_in_button;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mTvLoginName= (AutoCompleteTextView) findViewById(tvloginName);
        mTvPassword= (EditText) findViewById(R.id.tvLoginPassword);
        email_sign_in_button= (Button) findViewById(R.id.email_sign_in_button);
        email_sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request request = ItheimaHttp.newGetRequest("action/api/login_validate");//apiUrl格式："xxx/xxxxx"
                request.putParams("keep_login",1)
                        .putParams("username",mTvLoginName.getText().toString())
                        .putParams("pwd",mTvPassword.getText().toString());
                Call call = ItheimaHttp.send(request, new HttpResponseListener<String>() {
                    @Override
                    public void onResponse(String s, Headers headers) {
                        LoginBean loginBean= XmlUtils.toBean(LoginBean.class,s.getBytes());

                        Log.i("s",s);
                        //Log.i("s1",loginBean.result.errorCode);
                        if(loginBean.result.errorCode.equals("1")){
                            String name=loginBean.user.name;
                            Intent intent=new Intent(LoginActivity.this,BigActivity.class);
                            intent.putExtra("name",name);
                            startActivity(intent);
                        }else {
                            Toast.makeText(LoginActivity.this,"账号或密码有误，请重新输入",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable e) {
                    }
                });

            }
        });


    }
}

