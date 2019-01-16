package com.example.lab505b.dp2;

public class Student{
    private int id;
    private String name;

    public Student(int id, String name)
    {
        this.id=id; setName(name);
    }

    public int getid()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public String getNAme()
    {
        return name;
    }

    public void setName(String Name)

    {
        if(name.length()>0)
            this.name=name;
    }

    public String toString()
    {
        return "Student{"+"id"+id+" name"+name+"}";
    }
}