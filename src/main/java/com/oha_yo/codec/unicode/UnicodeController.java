package com.oha_yo.codec.unicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encoding")
public class UnicodeController {
	
	private static final Logger logger = LoggerFactory.getLogger(UnicodeController.class);

    private final UnicodeService unicodeService;

    // コンストラクタ注入（Springが自動でServiceをセットしてくれます）
    public UnicodeController(UnicodeService unicodeService) {
        this.unicodeService = unicodeService;
    }

    @GetMapping("/unicode")
    public String getUnicode(
            @RequestParam(name = "text") String text,
            @RequestParam(name = "format", defaultValue = "uplus") String format) {
        
    	logger.info("受信パラメータ - text: {}, format: {}", text, format);
        // ロジックはServiceにお任せ！
        return unicodeService.encode(text, format);
    }
}