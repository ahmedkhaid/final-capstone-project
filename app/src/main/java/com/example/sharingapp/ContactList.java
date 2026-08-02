package com.example.sharingapp;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
public class ContactList {
    private ArrayList<Contact> contacts;
    private String FILENAME="contacts.sav";
    public ContactList()
    {
        contacts = new ArrayList<Contact>();
    }
    public void setContacts(ArrayList<Contact>contacts) {
        this.contacts=contacts;
    }
    public ArrayList<Contact> getContacts()
    {
        return this.contacts;
    }
    public ArrayList<String> getAllUsernames()
    {
        ArrayList<String>result = new ArrayList<String>();
        for(Contact c  : contacts)
        {
            result.add(c.getUsername());
        }
        return result;
    }
    public void addContact(Contact contact)
    {
        contacts.add(contact);
    }
    public void deleteContact(Contact contact)
    {
        contacts.remove(contact);
    }
    public Contact getContact(int index)
    {


        return contacts.get(index);

    }
    public int getSize()
    {
        return contacts.size();
    }
    public int getIndex(Contact contact)
    {
        int pos=0;
        for(Contact c : contacts)
        {
            if(c.getId()==contact.getId())
            {
                return pos;
            }
            pos++;
        }
        return -1;
    }
    public boolean hasContact(Contact contact)
    {
        boolean result = false;
        for(Contact c : contacts)
        {
            if(c.getId()==contact.getId())
            {
                result =true;
            }

        }
        return result;
    }
    public Contact getContactByUsername(String userName)
    {

        for(Contact c : contacts)
        {
            if(c.getUsername().equals(userName))
            {
                return c;
            }
        }
        return null;
    }
    public boolean isUsernameAvailable(String userName)
    {
        boolean result = true;
        for(Contact c : contacts)
        {
            if(c.getUsername().equals(userName))
            {
                result=false;
            }
        }
        return result;
    }
    public void loadContacts(Context context)
    {

        try{
            FileInputStream fileInput =context.openFileInput(FILENAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInput);
            Type type = new TypeToken<ArrayList<Contact>>() {}.getType();
            Gson gson = new Gson();
            contacts = gson.fromJson(inputStreamReader,type);
            inputStreamReader.close();
            if(contacts == null)
            {
                contacts = new ArrayList<Contact>();
            }
        }
        catch (FileNotFoundException notFound) {
            //TODO: handle exception
            contacts = new ArrayList<Contact>();
        }
        catch(IOException ioException)
        {
            contacts = new ArrayList<Contact>();
        }

    }
    public void saveContacts(Context context)
    {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,0);
            OutputStreamWriter ows = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(contacts,ows);
            ows.flush();
            ows.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }

}