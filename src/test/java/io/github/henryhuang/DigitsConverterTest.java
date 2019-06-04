package io.github.henryhuang;

import static org.junit.Assert.assertEquals;

import io.github.henryhuang.digitsmapper.TelephoneButtonsDigitsMapper;
import io.github.henryhuang.digitsmapper.TelephoneButtonsDigitsMapperV2;
import java.security.InvalidParameterException;
import org.junit.Test;

/**
 * Created by Henry Huang on 2019/6/5.
 */
public class DigitsConverterTest {

  @Test
  public void testDigitsConverterWhenUsingMapperV1() {

    DigitsConverter converter = new DigitsConverterImpl(new TelephoneButtonsDigitsMapper());
    assertEquals("ad ae af bd be bf cd ce cf", converter.convert(new int[]{2, 3}));
    assertEquals("w x y z", converter.convert(new int[]{9}));

  }

  @Test(expected = InvalidParameterException.class)
  public void testThrowExceptionIfDigitGreaterThan9WhenUsingMapperV1() {

    DigitsConverter converter = new DigitsConverterImpl(new TelephoneButtonsDigitsMapper());
    assertEquals("w x y z", converter.convert(new int[]{0, 99}));

  }

  @Test
  public void testDigitsConverterWhenUsingMapperV2() {

    DigitsConverter converter = new DigitsConverterImpl(new TelephoneButtonsDigitsMapperV2());

    assertEquals("w x y z", converter.convert(new int[]{9}));
    assertEquals("w x y z", converter.convert(new int[]{9, 10}));
    assertEquals("w x y z", converter.convert(new int[]{0, 99}));
    assertEquals("aw ax ay az bw bx by bz cw cx cy cz dw dx dy dz ew ex ey ez fw fx fy fz", converter.convert(new int[]{9, 23}));

  }

}
