/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    private Button mNextbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // COMPLETED (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments

        // Will be 0 for HeadFragment, 1 for BodyFragment, and 2 for LegFragment
        int bodyPartNumber = position /12;

        // Converts bodyPartNumber into a valid list index. Insures value always between 0-11
        int listIndex = position - bodyPartNumber * 12;

        // Sets the currently displayed item for the correct body part fragment
        switch(bodyPartNumber) {
            case 0: headIndex = listIndex;
                    break;
            case 1: bodyIndex = listIndex;
                    break;
            case 2: legIndex = listIndex;
                    break;
            default: break;
        }

        // creates a bundle to store the index of the selected body part
        Bundle bundle = new Bundle();
        bundle.putInt("headIndex", headIndex);
        bundle.putInt("bodyIndex", bodyIndex);
        bundle.putInt("legIndex", legIndex);

        // starts the AndroidMeActivity
        final Intent startAndroidMeIntent = new Intent(this, AndroidMeActivity.class);
        startAndroidMeIntent.putExtras(bundle);

        // COMPLETED (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity

        // COMPLETED (4) Get a reference to the "Next" button and launch the intent when this button is clicked

        // creates a reference to the next button
        mNextbutton = (Button) findViewById(R.id.next_button);

       // launches AndroidMeActivity when the next button is clicked
        mNextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(startAndroidMeIntent);
            }
        });

    }

}
