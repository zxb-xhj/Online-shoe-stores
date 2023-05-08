package com.xhj.bean;

public class Shopping {
    private Integer id;

    private String name;

    private Integer code;

    private Integer price;
    
    

    public Shopping() {
		super();
	}

	public Shopping(Integer id, String name, Integer code, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
	}
	public Shopping(String name, Integer code, Integer price) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
	}
	public Shopping(Integer id) {
		super();
		this.id = id;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}