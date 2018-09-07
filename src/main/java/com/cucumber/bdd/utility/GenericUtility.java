package com.cucumber.bdd.utility;


public class GenericUtility
{
  public static String getResourcePath(String resource)
  {
    String path = GenericUtility.class.getClass().getResource("/").getPath() + resource;
    
    return path;
  }
}
