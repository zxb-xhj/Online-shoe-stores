package com.xhj.bean;

public class Footwear {
    private Integer id;

    private String name;
    
    

    public Footwear() {
		super();
	}

	public Footwear(String name) {
		super();
		this.name = name;
	}
	public Footwear(Integer id,String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Footwear [id=" + id + ", name=" + name + "]";
	}
    
}