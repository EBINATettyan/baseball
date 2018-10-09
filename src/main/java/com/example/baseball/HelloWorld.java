
/*
 * 1つ目はユーザからのアクセスを受け取ってテンプレートを返すファイル
 */

package com.example.baseball;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @Controllerをつけることで、このClassがユーザからのアクセスを受け付けることができる
 */
@Controller
public class HelloWorld {

	/*
	 * @GetMapping("/")とすると、httpメソッドがGETでURLが/のアクセスがあるとこのメソッドが呼ばれるようになる
	 * ()の中のパスは、http://localhost:8080に続く内容を表す
	 */
    @GetMapping("/hello")
    public String hello() {
        /*
         * src/main/resources/templates/配下のhello.htmlをユーザに返す
         */
    	return "hello";
    }
}