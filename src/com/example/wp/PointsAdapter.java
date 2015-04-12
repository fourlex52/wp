package com.example.wp;


import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by fourlex on 20.03.2015.
 */
public class PointsAdapter {
    // �������� ����� � ������� �������� ������
    private static String FILE_POINTS = "gpspoints";

    // ������ ��� �����
    ArrayList<String> recPoint;

    Context mContext;

    public PointsAdapter(Context context)
    {
        recPoint = new ArrayList<String> ();

        mContext = context;
        // ������ �� ����� � ������ � �������
        try {
            FileInputStream fis = mContext.openFileInput(FILE_POINTS);
            ObjectInputStream is = new ObjectInputStream(fis);
            recPoint = (ArrayList<String>) is.readObject();
            is.close();
        } catch (Exception e) {
            Toast.makeText(mContext, "��������� ������ ������ ������� �����", Toast.LENGTH_LONG);
        }
    }

    public void WritePoints ()
    {
        // ���������� ������ � ������� � ����
        try {
            FileOutputStream fos = mContext.openFileOutput(FILE_POINTS, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(recPoint);
            os.close();
        } catch (Exception e) {
            Toast.makeText(mContext, "��������� ������ ������ � ������� �����", Toast.LENGTH_LONG);
        }
        return;
    }

    public void addPoint (String num)
    {
        if (!recPoint.contains(num))
            recPoint.add(num);

        //Collections.sort(recPoint);

        //for (int i = 5; i < recPoint.size(); i++)
        //    recPoint.remove(i);

        return;
    }

    public ArrayList<String> getRecPoint()
    {
        // ������������ ������ ����� ����� � ������ �����
        ArrayList<String> arr = new ArrayList<String>();
        for (String temp : recPoint)
            arr.add(temp.toString());

        // ���������� ������ �������� �� �����
        return arr;
    }

    public void removeAllPoint()
    {
        try{
            FileOutputStream fos = mContext.openFileOutput(FILE_POINTS, Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            recPoint.clear();
            os.writeObject(recPoint);
            os.close();
            Toast.makeText(mContext, "�������� ���������", Toast.LENGTH_LONG);
        } catch (Exception e) {
        Toast.makeText(mContext, "��������� ������ ������ � ������� ����� (��������)", Toast.LENGTH_LONG);
    }

    }
}