package cn.imhtb.zone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.util.Res;

import java.util.List;

public class StartActivity extends AppCompatActivity {

    private String[] mArName;
    private List<ListItemBean> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置获取资源的上下文Context
        Res.addResource(this);
        // 设置App Id
        DuMixARConfig.setAppId("18125923");
        // 设置API Key
        DuMixARConfig.setAPIKey("H9h5bsdD3jGxi77UM6vbcx8z");
        // 设置Secret Key
        DuMixARConfig.setSecretKey("Dg5jIA14zattGyD3Nu5Hx9OlahTvEQe4");
        setContentView(R.layout.activity_start);

        initBar();
        initData();

        ImageView ivEarth = findViewById(R.id.iv_earth);
        ivEarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, ARActivity.class);
                Bundle bundle = new Bundle();

                ListItemBean listItemBean = new ListItemBean(5, "10314858", null, mArName[5]);
                //ListItemBean listItemBean = new ListItemBean(0, "10314856", null, mArName[5]);
                bundle.putString(Config.AR_KEY, listItemBean.getARKey());
                bundle.putInt(Config.AR_TYPE, listItemBean.getARType());
                bundle.putString(Config.AR_FILE, listItemBean.getCasePath());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void initData() {
        Resources res = getResources();
        mArName = res.getStringArray(R.array.ar_name);
    }

    private void initBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    private class ListItemBean {
        String mARKey;
        int mARType;
        String mCasePath;
        String mName;

        public ListItemBean(int arType, String arKey, String path, String name) {
            this.mARType = arType;
            this.mARKey = arKey;
            this.mName = name;
            this.mCasePath = path;
        }

        public String getARKey() {
            return mARKey;
        }

        public int getARType() {
            return mARType;
        }

        public String getName() {
            return mName;
        }

        public String getCasePath() {
            return mCasePath;
        }
    }
}
