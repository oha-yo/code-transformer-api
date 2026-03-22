package com.oha_yo.codec.unicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UnicodeService {
	private static final Logger logger = LoggerFactory.getLogger(UnicodeController.class);

    /**
     * 文字列をUnicodeエスケープ形式に変換する
     */
    public String encode(String text, String format) {
        if (text == null) return "";

        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            String hex = String.format("%04X", (int) c);
            
            // formatに応じた接頭辞の切り替え
            switch (format.toLowerCase()) {
                case "slashu":
                    sb.append("\\u").append(hex);
                    break;
                case "backslash":
                    sb.append("\\").append(hex);
                    break;
                case "uplus":
                default:
                    sb.append("U+").append(hex);
                    break;
            }
        }
        logger.info("UnicodeService.encode: {}", sb.toString());
        return sb.toString();
    }
}