package com.cosmax.apktool;

import org.junit.Test;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.*;

/**
 * @program: apktool
 * @description:
 * @author: Cosmax
 * @create: 2020/12/12 23:47
 */
public class LuaTest {

    @Test
    public void getLua(){

        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.load("function Decryption(jie,Text)\n" +
                "\n" +
                "  return (Text:gsub('..', function (jie)\n" +
                "\n" +
                "    return string.char((tonumber(jie,16))%256)\n" +
                "\n" +
                "  end))\n" +
                "\n" +
                "end\n" +
                "\n" +
                "local data = Decryption('DZSH','66756E6374696F6E2044656372797074696F6E286A69652C54657874290A0A202072657475726E2028546578743A6773756228272E2E272C2066756E6374696F6E20286A6965290A0A2020202072657475726E20737472696E672E636861722828746F6E756D626572286A69652C3136292925323536290A0A2020656E6429290A0A656E640A0A6C6F63616C2064617461203D2044656372797074696F6E2827445A5348272C27363637353645363337343639364636453230343436353633373237393730373436393646364532383641363936353243353436353738373432393041304132303230373236353734373537323645323032383534363537383734334136373733373536323238323732453245323732433230363637353645363337343639364636453230323836413639363532393041304132303230323032303732363537343735373236453230373337343732363936453637324536333638363137323238323837343646364537353644363236353732323836413639363532433331333632393239323533323335333632393041304132303230363536453634323932393041304136353645363430413041364336463633363136433230363436313734363132303344323034343635363337323739373037343639364636453238323734343541353334383237324332373336333633373335333634353336333333373334333633393336343633363435333233303334333433363335333633333337333233373339333733303337333433363339333634363336343533323338333634313336333933363335333234333335333433363335333733383337333433323339333034313330343133323330333233303337333233363335333733343337333533373332333634353332333033323338333533343336333533373338333733343333343133363337333733333337333533363332333233383332333733323435333234353332333733323433333233303336333633373335333634353336333333373334333633393336343633363435333233303332333833363431333633393336333533323339333034313330343133323330333233303332333033323330333733323336333533373334333733353337333233363435333233303337333333373334333733323336333933363435333633373332343533363333333633383336333133373332333233383332333833373334333634363336343533373335333634343336333233363335333733323332333833363431333633393336333533323433333333313333333633323339333233393332333533333332333333353333333633323339333034313330343133323330333233303336333533363435333633343332333933323339333034313330343133363335333634353336333433303431333034313336343333363436333633333336333133363433333233303336333433363331333733343336333133323330333334343332333033343334333633353336333333373332333733393337333033373334333633393336343633363435333233383332333733343334333534313335333333343338333233373332343333323337333333303334333133333336333333363333333733333335333333363334333533333336333333333333333733333334333333363333333933333336333433363333333633343335333333323333333033333334333433343333333633333331333333363333333933333336333433353333333233333338333333323333333933333330333433313333333233333330333333323333333033333335333333333333333433343335333333323333333033333333333433343333333233333330333333363333333733333336333333373333333233343335333333363333333333333336333333383333333633343336333333363333333933333336333333333333333633333335333333323333333833333337333433323333333033343331333333323333333033333332333333303333333233333330333333323333333033333332333333323334333533333335333433323334333333333338333333303334333533333335333333393333333033343331333433363333333233333332333333323334333333333330333433313333333233333330333333323333333033333332333333303333333233333330333333323333333233343335333333393333333833333330333333383333333033343335333333353333333833333337333433323334333133343335333333383333333833333334333333393334333133343335333333363333333933343333333433313334333333333332333333323333333033343331333333323333333033333332333333303333333733343334333333323334333333333332333333303333333333333332333333333333333033333333333333313333333333333338333333323334333333333332333333303333333233333332333433353333333533333339333433323334333233343335333433353333333533333339333433323334333233343335333333333333333233333333333333363333333333333334333333333333333033333333333333393333333333333331333333333333333933333333333333303333333333333337333333333333333433333332333333323333333233333339333333303334333133333332333333303333333233333330333333363333333933333336333333363333333233333330333333353333333333333334333433353333333233333330333333333334333433333333333433343333333233333330333333333333333133333332333333303333333733333334333333363333333833333336333333353333333633343335333333303334333133333332333333303333333233333330333333323333333033333332333333303333333633333331333333323333333833333332333333393333333033343331333333323333333033333332333333303333333633333335333333363334333533333336333333343333333033343331333333323333333033333332333333303333333633333339333333363333333633333332333333303333333533333333333333343334333533333332333333303333333333343334333333333334333433333332333333303333333333333332333333323333333033333337333333343333333633333338333333363333333533333336333433353333333033343331333333323333333033333332333333303333333233333330333333323333333033333334333333353333333733333338333333363333333933333337333333343333333233333338333333323333333933333330333433313333333233333330333333323333333033333336333333353333333633343335333333363333333433333330333433313333333233333330333333323333333033333335333333383333333433333337333333343333333333333334333433323333333233333330333333333334333433333332333333303333333233343334333333333333333133333330333433313333333633333335333333363334333533333336333333343333333033343331333333303334333133333330333433313333333033343331333333363333333633333337333333353333333633343335333333363333333333333337333333343333333633333339333333363334333633333336333433353333333233333330333333363333333133333332333333383333333233333339333333303334333133333332333333303333333233333330333333323333333033333332333333303333333633333337333333363333333733333332333433353333333633333333333333363334333333333336333333353333333633333331333333373333333233333335333333323333333633333335333333373333333333333337333333353333333633343333333333373333333433333337333333333333333233333338333333323333333933333330333433313333333233333330333333323333333033333332333333303333333233333330333333363333333733333336333333373333333233343335333333373333333333333336333333353333333733333334333333353333333233333336333333313333333633343335333333363333333733333336333333353333333733333333333333323333333833333336333333373333333633333337333333323334333533333335333333323333333433333335333333343333333733333334333333393333333433343336333333343334333533333335333433363333333433333333333333353334333633333334333333313333333433343333333333343334333333333334333433363333333433333333333333323333333933333330333433313333333233333330333333323333333033333332333333303333333233333330333333363333333733333336333333373333333233343335333333373333333333333336333333353333333633333331333333373333333233333336333333333333333633333338333333343334333533333337333333353333333633343334333333363333333233333336333333353333333733333332333333323333333833333332333333323333333333343331333333363333333733333336333433333333333633343336333333363333333233333336333333313333333633343333333333353334333633333332333333323333333233343333333333363333333733333336333333373333333233343335333333353333333433333335333333393333333533333330333333343333333533333335333433363333333433333332333333353333333933333335333333343333333433333335333333323334333333333336333333363333333633333331333333363334333333333337333333333333333633333335333333323334333333333336333333373333333633333337333333323334333533333335333333333333333433333339333333343333333733333334333433353333333533343336333333343333333533333335333333313333333533333335333333343333333133333334333433333333333233343333333333333333333033333332333433333333333233333330333333323334333433333333333333313333333233333339333333303334333133333332333333303333333233333330333333323333333033333332333333303333333633333337333333363333333733333332333433353333333733333333333333363333333533333336333333313333333733333332333333363333333333333336333333383333333433343335333333373333333533333336333433343333333633333332333333363333333533333337333333323333333233333338333333323333333233333332333333323333333233343333333333363333333733333336333333373333333233343335333333353333333433333335333333393333333533333330333333343333333533333335333433363333333433333332333333353333333933333335333333343333333433333335333333323334333333333336333333363333333633333331333333363334333333333337333333333333333633333335333333323334333333333336333333373333333633333337333333323334333533333335333333333333333433333339333333343333333733333334333433353333333533343336333333343333333533333335333333313333333533333335333333343333333133333334333433333333333233343333333333333333333033333332333433333333333233333330333333323334333433333333333333313333333233333339333333303334333133333332333333303333333233333330333333323333333033333332333333303333333633333337333333363333333733333332333433353333333633333337333333363333333533333337333333343333333533333332333333363333333533333337333333333333333733333335333333363334333333333337333333343333333733333333333333323333333833333333333333393333333333333339333333333333333933333333333333393333333233333339333333303334333133333332333333303333333233333330333333323333333033333332333333303333333633333337333333363333333733333332333433353333333633333335333333363333333433333336333333393333333733333334333333343333333133333336333433333333333633343333333333323333333833333332333333323333333333343331333333353333333433333335333333343333333233333332333333323334333333333336333333373333333633333337333333323334333533333335333333343333333533333339333333353333333033333334333333353333333533343336333333343333333233333335333333393333333533333334333333343333333533333332333333393333333033343331333333323333333033333332333333303333333233333330333333323333333033333336333333373333333633333337333333323334333533333336333333333333333633343333333333363333333533333336333333313333333733333332333333353333333233333336333333353333333733333333333333373333333533333336333433333333333733333334333333373333333333333332333333383333333233333339333333303334333133333332333333303333333233333330333333323333333033333332333333303333333633333337333333363333333733333332333433353333333733333333333333363333333533333337333333343333333533333332333333363333333133333336333433353333333633333337333333363333333533333337333333333333333233333338333333363333333733333336333333373333333233343335333333353333333233333334333333353333333433333337333333343333333933333334333433363333333433343335333333353334333633333334333333333333333533343336333333343333333133333334333433333333333433343333333333343334333633333334333333333333333233333339333333303334333133333332333333303333333233333330333333323333333033333332333333303333333633333337333333363333333733333332333433353333333733333333333333363333333533333336333333313333333733333332333333363333333333333336333333383333333433343335333333373333333533333336333433343333333633333332333333363333333533333337333333323333333233333338333333323333333233333333333433313333333733333333333333363333333533333336333333313333333733333333333333363334333633333336333433353333333533343336333333333333333033333333333333353333333233333332333333323334333333333336333333373333333633333337333333323334333533333335333333343333333533333339333333353333333033333334333333353333333533343336333333343333333233333335333333393333333533333334333333343333333533333332333433333333333633333336333333363333333133333336333433333333333733333333333333363333333533333332333433333333333633333337333333363333333733333332333433353333333533333333333333343333333933333334333333373333333433343335333333353334333633333334333333353333333533333331333333353333333533333334333333313333333433343333333333323334333333333333333333303333333233343333333333323333333033333332333433343333333333333331333333323333333933333330333433313333333233333330333333323333333033333332333333303333333233333330333333363333333733333336333333373333333233343335333333373333333333333336333333353333333633333331333333373333333233333336333333333333333633333338333333343334333533333337333333353333333633343334333333363333333233333336333333353333333733333332333333323333333833333332333333323333333233333332333333323334333333333336333333373333333633333337333333323334333533333335333333343333333533333339333333353333333033333334333333353333333533343336333333343333333233333335333333393333333533333334333333343333333533333332333433333333333633333336333333363333333133333336333433333333333733333333333333363333333533333332333433333333333633333337333333363333333733333332333433353333333533333333333333343333333933333334333333373333333433343335333333353334333633333334333333353333333533333331333333353333333533333334333333313333333433343333333333323334333333333333333333303333333233343333333333323333333033333332333433343333333333333331333333323333333933333330333433313333333233333330333333323333333033333332333333303333333233333330333333363333333733333336333333373333333233343335333333363333333733333336333333353333333733333334333333353333333233333336333333353333333733333333333333373333333533333336333433333333333733333334333333373333333333333332333333383333333333333339333333333333333933333333333333393333333333333339333333323333333933333330333433313333333233333330333333323333333033333332333333303333333233333330333333363333333733333336333333373333333233343335333333363333333533333336333333343333333633333339333333373333333433333334333333313333333633343333333333363334333333333332333333383333333233333332333333333334333133333335333333343333333533333334333333323333333233333332333433333333333633333337333333363333333733333332333433353333333533333334333333353333333933333335333333303333333433333335333333353334333633333334333333323333333533333339333333353333333433333334333333353333333233333339333333323333333033333332333333303333333233333330333333323333333033333330333433313333333233333330333333323333333033333332333333303333333233333330333333363333333733333336333333373333333233343335333333363333333333333336333433333333333633333335333333363333333133333337333333323333333533333332333333363333333533333337333333333333333733333335333333363334333333333337333333343333333733333333333333323333333833333332333333393333333033343331333333323333333033333332333333303333333233333330333333323333333033333336333333373333333633333337333333323334333533333337333333333333333633333335333333373333333433333335333333323333333633333331333333363334333533333336333333373333333633333335333333373333333333333332333333383333333633333337333333363333333733333332333433353333333533333332333333343333333533333334333333373333333433333339333333343334333633333334333433353333333533343336333333343333333333333334333433363333333433333334333333343333333533333335333433363333333433333331333333353333333033333335333333303333333233333339333333303334333133333332333333303333333233333330333333323333333033333332333333303333333633333337333333363333333733333332333433353333333733333333333333363333333533333336333333313333333733333332333333363333333333333336333333383333333433343335333333373333333533333336333433343333333633333332333333363333333533333337333333323333333233333338333333323333333233333333333333353333333233343333333333333333333433333333333333363333333333333330333333323334333333333333333333383333333333333330333333333333333133333333333433323333333333333338333333333333333233333333333333353333333233343333333333333333333233333333333333343333333333333336333333323334333333333333333333353333333333333334333333333333333233333333333333313333333233343333333333333333333333333333333333303333333333333338333333323334333333333333333333363333333333333333333333333333333633333332333433333333333333333334333333333333333633333333333333343333333333343332333333333333333933333333333333303333333333333339333333323334333333333333333333313333333333333339333333333333333833333332333433333333333333333331333333333333333533333333333333383333333333343331333333333334333133333332333333323333333233343333333333363333333733333336333333373333333233343335333333353333333433333335333333393333333533333330333333343333333533333335333433363333333433333334333333353333333733333334333433363333333533333332333333343333333433333332333433333333333633333336333333363333333133333336333433333333333733333333333333363333333533333332333433333333333633333337333333363333333733333332333433353333333533333333333333343333333933333334333333373333333433343335333333353334333633333334333333353333333533333331333333353333333533333334333333313333333433343333333333323334333333333333333333303333333233343333333333323333333033333332333433343333333333333331333333323333333933333330333433313333333233333330333333323333333033333332333333303333333233333330333333363333333733333336333333373333333233343335333333373333333333333336333333353333333633333331333333373333333233333336333333333333333633333338333333343334333533333337333333353333333633343334333333363333333233333336333333353333333733333332333333323333333833333332333333323333333233333332333333323334333333333336333333373333333633333337333333323334333533333335333333343333333533333339333333353333333033333334333333353333333533343336333333343333333433333335333333373333333433343336333333353333333233333334333333343333333233343333333333363333333633333336333333313333333633343333333333373333333333333336333333353333333233343333333333363333333733333336333333373333333233343335333333353333333333333334333333393333333433333337333333343334333533333335333433363333333433333335333333353333333133333335333333353333333433333331333333343334333333333332333433333333333333333330333333323334333333333332333333303333333233343334333333333333333133333332333333393333333033343331333333323333333033333332333333303333333233333330333333323333333033333336333333373333333633333337333333323334333533333336333333373333333633333335333333373333333433333335333333323333333633333335333333373333333333333337333333353333333633343333333333373333333433333337333333333333333233333338333333333333333933333333333333393333333333333339333333333333333933333332333333393333333033343331333333323333333033333332333333303333333233333330333333323333333033333336333333373333333633333337333333323334333533333336333333353333333633333334333333363333333933333337333333343333333433333331333333363334333333333336333433333333333233333338333333323333333233333333333333303333333233333332333333323334333333333336333333373333333633333337333333323334333533333335333333343333333533333339333333353333333033333334333333353333333533343336333333343333333433333335333333373333333433343336333333353333333233333334333333343333333233333339333333303334333133333332333333303333333233333330333333323333333033333332333333303333333633333337333333363333333733333332333433353333333733333334333333363334333633333336333333313333333733333333333333373333333433333332333333383333333233333332333433353333333533343332333433333333333833333330333433353333333533333339333333303334333133343336333433353333333633333338333333383333333933333330333433353333333533333338333433313333333933343336333433353334333633343332333433333333333833343333333433353333333733333338333333323334333233333339333433353333333533343332333433333333333833333330333433353333333533333339333333353333333833333336333433353333333533343332333433313333333933333337333433353333333533333338333433343334333233333333333433353333333533333338333433363334333133343336333333323333333233333332333333393333333033343331333333363333333533333336333433353333333633333334333333303334333133333330333433313333333033343331333333303334333133333330333433313333333033343331333333363333333633333337333333353333333633343335333333363333333333333337333333343333333633333339333333363334333633333336333433353333333233333330333333343333333533333337333333383333333633333339333333373333333433333332333333383333333233333339333333303334333133333332333333303333333233333330333333323333333033333337333333303333333733333332333333363333333933333336333433353333333733333334333333323333333833333332333333323334333533333335333333393334333233343332333433353334333533333335333333393334333233343332333433353334333533333334333433323334333333333339333433313334333533333339333433313333333333333339333433353333333233333332333333323333333933333330333433313333333233333330333333323333333033333336333433363333333733333333333333323334333533333336333333353333333733333338333333363333333933333337333333343333333233333338333333323333333933333330333433313333333633333335333333363334333533333336333333343333333033343331333333303334333133333330333433313333333033343331333333363333333333333337333333333333333233333330333333333334333433333332333333303333333233333332333433353333333533333339333433323334333233343335333433353333333533333339333433323334333233343335333433353333333933343331333333333333333933343335333433353333333833343332333333353334333233333337333433353333333633333339333433343334333133333335333433353333333433343332333433313333333833333336333433353334333633343332333433333333333833333331333433353334333633343332333433333333333833333331333433353334333633343332333433333333333833333331333333323333333233333330333433313333333733333337333333363333333833333336333333393333333633343333333333363333333533333332333333303333333733333334333333373333333233333337333333353333333633333335333333323333333033333336333333343333333633343336333333303334333133333332333333303333333233333330333333363333333933333336333333363333333233333330333333363333333733333336333333373333333233343335333333363333333933333337333333333333333533333336333333363333333933333337333333333333333633333339333333363333333233333336333433333333333633333335333333323333333833333337333333343333333733333332333333373333333533333336333333353333333233333339333333323333333033333337333333343333333633333338333333363333333533333336333433353333333033343331333333323333333033333332333333303333333233333330333333323333333033333335333333383333333433333337333333343333333333333334333433323333333233333330333333333334333433333332333333303333333333333331333333303334333133333332333333303333333233333330333333323333333033333332333333303333333633333337333333363333333733333332333433353333333733333333333333363333333533333337333333343333333533333336333333363333333933333337333333333333333633333339333333363333333233333336333433333333333633333335333333323333333833333336333333363333333633333331333333363334333333333337333333333333333633333335333333323333333933333330333433313333333233333330333333323333333033333336333333353333333633343335333333363333333433333330333433313333333233333330333333323333333033333336333333373333333633333337333333323334333533333336333333333333333633343333333333363333333533333336333333313333333733333332333333353333333233333336333333353333333733333333333333373333333533333336333433333333333733333334333333373333333333333332333333383333333233333339333333303334333133333332333333303333333233333330333333363333333933333336333333363333333233333330333333353333333833333334333333373333333433333333333333343334333233333332333333303333333333343334333333333334333433333332333333303333333333333331333333323333333033333337333333343333333633333338333333363333333533333336333433353333333033343331333333323333333033333332333333303333333233333330333333323333333033333334333433343333333633333331333333363333333933333336333433353333333233333338333333323333333933333330333433313333333233333330333333323333333033333336333333353333333633343335333333363333333433333330333433313333333633333335333333363334333533333336333333343333333033343331333333303334333133323337333233393330343133303431333634333336343633363333333633313336343333323330333633343337343133373333333633383332333033333434333233303336343333363436333633313336333433323338333633343336333133373334333633313332333933303431333034313337333033363333333633313336343333363433333233383336333433373431333733333336333833323339333034313237323930413041364336463633363136433230363437413733363832303344323036433646363136343238363436313734363132393041304137303633363136433643323836343741373336383239304127290A0A6C6F63616C20647A7368203D206C6F61642864617461290A0A7063616C6C28647A7368290A')\n" +
                "\n" +
                "local dzsh = load(data)\n" +
                "print(dzsh)");
//        LuaValue chunk = globals.loadfile("C:\\Users\\Conanbin\\Documents\\Tencent Files\\491217737\\FileRecv\\一键全物品.lua");
        chunk.call();


    }
}