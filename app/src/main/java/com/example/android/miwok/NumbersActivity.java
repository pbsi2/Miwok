/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class NumbersActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        mRecyclerView = (RecyclerView) findViewById(R.id.numbersview);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // For LINEAR
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        // For a GRID
        //mLayoutManager = new GridLayoutManager(this,5);
        mRecyclerView.setLayoutManager(mLayoutManager);
        final MyWords[] words = {
                new MyWords(R.mipmap.guitar, "one", "lutti"),
                new MyWords(R.mipmap.guitar, "two", "ottiko"),
                new MyWords(R.mipmap.guitar, "three", "tolookosu"),
                new MyWords(R.mipmap.guitar, "four", "oyyisa"),
                new MyWords(R.mipmap.guitar, "five", "massokka"),
                new MyWords(R.mipmap.guitar, "six", "temmaokka"),
                new MyWords(R.mipmap.guitar, "seven", "keneokka"),
                new MyWords(R.mipmap.guitar, "eight", "kawinta"),
                new MyWords(R.mipmap.guitar, "nine", "wo'e"),
                new MyWords(R.mipmap.guitar, "ten", "na'aacha")
        };
        int lw = words.length;
        int[] image = new int[lw];
        String[] defaultTrans = new String[lw];
        String[] defaultNiwok = new String[lw];
        for (int i = 0; i < lw; i++) {
            image[i] = words[i].getImageId();
            defaultTrans[i] = words[i].getDefaultTranslation();
            defaultNiwok[i] = words[i].getMiwokTranslation();
        }
        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(image, defaultTrans, defaultNiwok);
        mRecyclerView.setAdapter(mAdapter);

    }
}
