package com.xhj.bean;

public class Shoes {
    private Integer id;

    private String name;

    private Integer price;

    private Integer hid;
    
    

    public Shoes(String name) {
		super();
		this.name = name;
	}

	public Shoes(Integer id, String name, Integer price, Integer hid) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.hid = hid;
	}
	public Shoes(String name, Integer price, Integer hid) {
		super();
		this.name = name;
		this.price = price;
		this.hid = hid;
	}
	public Shoes(Integer id, String name, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Shoes(Integer hid) {
		super();
		this.hid = hid;
	}

	public Shoes() {
		super();
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }
}