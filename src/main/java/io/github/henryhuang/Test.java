package io.github.henryhuang;

import io.github.henryhuang.digitsmapper.DigitsMapper;
import io.github.henryhuang.digitsmapper.TelephoneButtonsDigitsMapperV2;

/**
 * Created by Henry Huang on 2019/6/5.
 */
public class Test {

  public static void main(String[] args) {

    DigitsConverterImpl converter = new DigitsConverterImpl();

    System.out.println(converter.convert(new int[]{2, 3}));
    System.out.println(converter.convert(new int[]{9}));

    DigitsMapper digitsMapper = new TelephoneButtonsDigitsMapperV2();
    converter = new DigitsConverterImpl(digitsMapper);

    System.out.println(converter.convert(new int[]{9}));
    System.out.println(converter.convert(new int[]{9, 10}));
    System.out.println(converter.convert(new int[]{9, 23}));

  }

}
