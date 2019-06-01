package br.com.caelum.ingresso.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrecoUtil {
	public static BigDecimal verificaPreco(BigDecimal preco) {
		if(preco != null)
			return preco.setScale(2, RoundingMode.HALF_UP);
		else return preco;
	}
}
