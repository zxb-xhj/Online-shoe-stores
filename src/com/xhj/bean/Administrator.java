package com.xhj.bean;

public class Administrator {
    private Integer id;

    private String name;

    private String sex;

    private String pwd;
    
    

    public Administrator() {
		super();
	}

	public Administrator(Integer id, String name, String sex, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.pwd = pwd;
	}
	public Administrator(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
}