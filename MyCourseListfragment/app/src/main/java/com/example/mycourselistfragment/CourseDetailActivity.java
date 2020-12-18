package com.example.mycourselistfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import data.Course;
import data.CourseData;

public class CourseDetailActivity extends AppCompatActivity {

    Course course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        if (savedInstanceState == null){

            Bundle extra = getIntent().getExtras();
            int position = extra.getInt("course_id");

            course = new CourseData().courseList().get(position);

            CourseDetailFragment fragment = new CourseDetailFragment();
            fragment.setArguments(extra);
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.detailContainer, fragment)
                    .commit();

        }

    }
}