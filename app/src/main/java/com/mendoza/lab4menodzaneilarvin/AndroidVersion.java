package com.mendoza.lab4menodzaneilarvin;

public class AndroidVersion {
    private int logo;
    private String company, country, industry, ceo, info;

    public AndroidVersion(int logo, String company, String country, String industry, String ceo) {
        this.logo = logo;
        this.company = company;
        this.country = country;
        this.industry = industry;
        this.ceo = ceo;
        this.info = info;
    }

    public int getLogo() {
        return logo;
    }

    public String getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public String getIndustry() {
        return industry;
    }

    public String getCeo() {
        return ceo;
    }

    public String getInfo() {
        return info;
    }
}
