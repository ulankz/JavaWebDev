package main;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.Assert;


public class Test{

@org.junit.Test
public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect(){
  Object person = new Person();
  Field[] fields = person.getClass().getDeclaredFields();
  List<String> actualFieldNames = getFieldNames(fields);
  Assert.assertTrue(Arrays.asList("name","age").containsAll(actualFieldNames));
}

  private static List<String> getFieldNames(Field[] fields){
    List<String> fieldNames = new ArrayList<>();
    for(Field field:fields){
      fieldNames.add(field.getName());
    }
    return fieldNames;
  }
}
