package com.example.wherever_i_want;


import com.example.wherever_i_want.database.DbRecording;

public class Main {

    public static void main(String[] args) throws Exception {
        DbRecording dbRecording = DbRecording.getDbRecording();
    }
}
