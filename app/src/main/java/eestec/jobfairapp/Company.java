package eestec.jobfairapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by XMAN on 5.10.2016.
 */
public class Company {

    String name;
    private String email;
    private String web;
    private String adresa;
    private String telefon;
    private String okupacija;
    private int id;

    String image;
    String imgUrl;
    private CompanyAdapter company_adapter;

    public Activity activity;
    public Company( Activity _activity){ this.activity = _activity; }

    public Company(String name, String email, String web, String address, String phone, String ocuppation, int id, String imgUrl) {
        this.name = name;
        this.email = email;
        this.web = web;
        this.adresa = address;
        this.telefon = phone;
        this.okupacija = ocuppation;
        this.id = id;
        this.imgUrl = imgUrl;
        this.image = null;
    }

    public Company(String name, String email, String web) {
        super();
        this.name = name;
        this.email = email;
        this.web = web;
        this.image = null;
    }
    public Company(int id,String name, String email, String web) {
        super();
        this.id=id;
        this.name = name;
        this.email = email;
        this.web = web;
        this.image = null;
    }
    public Company(String name) {
        super();
        this.name = name;
        this.image = null;
    }

    public Company() { super(); }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getOkupacija() {
        return okupacija;
    }

    public void setOkupacija(String okupacija) {
        this.okupacija = okupacija;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void loadImage(CompanyAdapter sta) {
        // HOLD A REFERENCE TO THE ADAPTER
        this.company_adapter = sta;
        ImageView iv = (ImageView)this.activity.findViewById(R.id.company_logo);
        //if (imgUrl != null && !imgUrl.equals("")) {
          //  new LoadImageTask(iv).execute(imgUrl);
        //}
        iv.setImageResource(R.drawable.jf_logo);

    }



}
