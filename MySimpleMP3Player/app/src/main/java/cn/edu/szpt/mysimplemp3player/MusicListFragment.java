package cn.edu.szpt.mysimplemp3player;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import cn.edu.szpt.mysimplemp3player.services.PlayMusicService;
import cn.edu.szpt.mysimplemp3player.utils.SMPConstants;

/**
 * Created by Fly on 2018/5/29.
 */

public class MusicListFragment extends Fragment {
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_musiclist,container,false);
        listView = (ListView) view.findViewById(R.id.muscilist);
        listView.setAdapter(MainActivity.musicListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.currentIndex=position;
                MainActivity.musicListAdapter.refreshSelectPosition();
                Intent i = new Intent(getActivity(),PlayMusicService.class);
                //int progress=seekBar.getProgress();
                i.putExtra("CMD", SMPConstants.CMD_PLAYATPOSITION);
                i.putExtra("index",position);
                getActivity().startService(i);
            }
        });
        return view;
    }
}
