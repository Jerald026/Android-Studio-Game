package com.example.hp.junscape;


public class Trash
{
    private String trash_name;
    private String trash_type;
    private String dispose_detail;
    private String dispose_info;


    public Trash(String trash_name, String trash_type, String dispose_detail, String dispose_info) {
        this.trash_name = trash_name;
        this.trash_type = trash_type;
        this.dispose_detail = dispose_detail;
        this.dispose_info = dispose_info;
    }
    public void changeText(String text){
        dispose_detail =  text;

    }

    public String gettrash_name() {
        return trash_name;
    }

    public void settrash_name(String trash_name) {
        this.trash_name = trash_name;
    }

    public String gettrash_type() {
        return trash_type;
    }

    public void settrash_type(String trash_type) {
        this.trash_type = trash_type;
    }

    public String getdispose_detail() {
        return dispose_detail;
    }

    public void setdispose_detail(String dispose_detail) {
        this.dispose_detail = dispose_detail;
    }

    public String getdispose_info() {
        return dispose_info;
    }

    public void setdispose_info(String dispose_info) {
        this.dispose_info = dispose_info;
    }
}
