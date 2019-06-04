package io.github.henryhuang;

import static org.junit.Assert.assertEquals;

import io.github.henryhuang.digitsmapper.DigitsMapper;
import io.github.henryhuang.digitsmapper.TelephoneButtonsDigitsMapper;
import io.github.henryhuang.digitsmapper.TelephoneButtonsDigitsMapperV2;
import java.security.InvalidParameterException;
import org.junit.Test;

/**
 * Created by Henry Huang on 2019/6/5.
 */
public class DigitsMapperTest {

  @Test
  public void testZeroAndOneAreNotMapAnyLetters() {

    DigitsMapper digitsMapper = new TelephoneButtonsDigitsMapper();
    assertEquals("", digitsMapper.map(0));
    assertEquals("", digitsMapper.map(1));

    digitsMapper = new TelephoneButtonsDigitsMapperV2();
    assertEquals("", digitsMapper.map(0));
    assertEquals("", digitsMapper.map(1));

  }

  @Test
  public void testDigitsMappingByUsingV1() {
    DigitsMapper digitsMapper = new TelephoneButtonsDigitsMapper();
    assertEquals("abc", digitsMapper.map(2));
    assertEquals("def", digitsMapper.map(3));
    assertEquals("ghi", digitsMapper.map(4));
    assertEquals("jkl", digitsMapper.map(5));
    assertEquals("mno", digitsMapper.map(6));
    assertEquals("pqrs", digitsMapper.map(7));
    assertEquals("tuv", digitsMapper.map(8));
    assertEquals("wxyz", digitsMapper.map(9));
  }

  @Test(expected = InvalidParameterException.class)
  public void testThrowExceptionIfMapDoubleDigitByUsingV1() {
    DigitsMapper digitsMapper = new TelephoneButtonsDigitsMapper();
    digitsMapper.map(23);
  }

  @Test(expected = InvalidParameterException.class)
  public void testThrowExceptionIfMapNegativeByUsingV1() {
    DigitsMapper digitsMapper = new TelephoneButtonsDigitsMapper();
    digitsMapper.map(-1);
  }

  // Test V2

  @Test
  public void testDigitsMappingByUsingV2() {

    DigitsMapper digitsMapper = new TelephoneButtonsDigitsMapperV2();
    assertEquals("abc", digitsMapper.map(2));
    assertEquals("def", digitsMapper.map(3));
    assertEquals("ghi", digitsMapper.map(4));
    assertEquals("jkl", digitsMapper.map(5));
    assertEquals("mno", digitsMapper.map(6));
    assertEquals("pqrs", digitsMapper.map(7));
    assertEquals("tuv", digitsMapper.map(8));
    assertEquals("wxyz", digitsMapper.map(9));

    assertEquals("", digitsMapper.map(10));
    assertEquals("wxyz", digitsMapper.map(19));
    assertEquals("abcdef", digitsMapper.map(23));

  }

}
