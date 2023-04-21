package io.github.mihaildemidoff.reactive.tg.bots.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Language codes in iso 639-1
 */
@RequiredArgsConstructor
public enum LanguageCode {

    /**
     * Afar
     */
    AFAR("aa"),

    /**
     * Abkhaz
     */
    ABKHAZ("ab"),

    /**
     * Avestan
     */
    AVESTAN("ae"),

    /**
     * Afrikaans
     */
    AFRIKAANS("af"),

    /**
     * Akan
     */
    AKAN("ak"),

    /**
     * Amharic
     */
    AMHARIC("am"),

    /**
     * Aragonese
     */
    ARAGONESE("an"),

    /**
     * Arabic
     */
    ARABIC("ar"),

    /**
     * Assamese
     */
    ASSAMESE("as"),

    /**
     * Avaric
     */
    AVARIC("av"),

    /**
     * Aymara
     */
    AYMARA("ay"),

    /**
     * Azerbaijani
     */
    AZERBAIJANI("az"),

    /**
     * Bashkir
     */
    BASHKIR("ba"),

    /**
     * Belarusian
     */
    BELARUSIAN("be"),

    /**
     * Bulgarian
     */
    BULGARIAN("bg"),

    /**
     * Bihari
     */
    BIHARI("bh"),

    /**
     * Bislama
     */
    BISLAMA("bi"),

    /**
     * Bambara
     */
    BAMBARA("bm"),

    /**
     * Bengali
     */
    BENGALI("bn"),

    /**
     * Tibetan
     */
    TIBETAN("bo"),

    /**
     * Breton
     */
    BRETON("br"),

    /**
     * Bosnian
     */
    BOSNIAN("bs"),

    /**
     * Catalan
     */
    CATALAN("ca"),

    /**
     * Chechen
     */
    CHECHEN("ce"),

    /**
     * Chamorro
     */
    CHAMORRO("ch"),

    /**
     * Corsican
     */
    CORSICAN("co"),

    /**
     * Cree
     */
    CREE("cr"),

    /**
     * Czech
     */
    CZECH("cs"),

    /**
     * Old
     */
    OLD("cu"),

    /**
     * Chuvash
     */
    CHUVASH("cv"),

    /**
     * Welsh
     */
    WELSH("cy"),

    /**
     * Danish
     */
    DANISH("da"),

    /**
     * German
     */
    GERMAN("de"),

    /**
     * Divehi
     */
    DIVEHI("dv"),

    /**
     * Dzongkha
     */
    DZONGKHA("dz"),

    /**
     * Ewe
     */
    EWE("ee"),

    /**
     * Greek
     */
    GREEK("el"),

    /**
     * English
     */
    ENGLISH("en"),

    /**
     * Esperanto
     */
    ESPERANTO("eo"),

    /**
     * Spanish
     */
    SPANISH("es"),

    /**
     * Estonian
     */
    ESTONIAN("et"),

    /**
     * Basque
     */
    BASQUE("eu"),

    /**
     * Persian
     */
    PERSIAN("fa"),

    /**
     * Fula
     */
    FULA("ff"),

    /**
     * Finnish
     */
    FINNISH("fi"),

    /**
     * Fijian
     */
    FIJIAN("fj"),

    /**
     * Faroese
     */
    FAROESE("fo"),

    /**
     * French
     */
    FRENCH("fr"),

    /**
     * Western
     */
    WESTERN("fy"),

    /**
     * Irish
     */
    IRISH("ga"),

    /**
     * Scottish
     */
    SCOTTISH("gd"),

    /**
     * Galician
     */
    GALICIAN("gl"),

    /**
     * Gujarati
     */
    GUJARATI("gu"),

    /**
     * Manx
     */
    MANX("gv"),

    /**
     * Hausa
     */
    HAUSA("ha"),

    /**
     * Hebrew
     */
    HEBREW("he"),

    /**
     * Hindi
     */
    HINDI("hi"),

    /**
     * Hiri
     */
    HIRI("ho"),

    /**
     * Croatian
     */
    CROATIAN("hr"),

    /**
     * Haitian
     */
    HAITIAN("ht"),

    /**
     * Hungarian
     */
    HUNGARIAN("hu"),

    /**
     * Armenian
     */
    ARMENIAN("hy"),

    /**
     * Herero
     */
    HERERO("hz"),

    /**
     * Interlingua
     */
    INTERLINGUA("ia"),

    /**
     * Indonesian
     */
    INDONESIAN("id"),

    /**
     * Interlingue
     */
    INTERLINGUE("ie"),

    /**
     * Igbo
     */
    IGBO("ig"),

    /**
     * Nuosu
     */
    NUOSU("ii"),

    /**
     * Inupiaq
     */
    INUPIAQ("ik"),

    /**
     * Ido
     */
    IDO("io"),

    /**
     * Icelandic
     */
    ICELANDIC("is"),

    /**
     * Italian
     */
    ITALIAN("it"),

    /**
     * Inuktitut
     */
    INUKTITUT("iu"),

    /**
     * Japanese
     */
    JAPANESE("ja"),

    /**
     * Javanese
     */
    JAVANESE("jv"),

    /**
     * Georgian
     */
    GEORGIAN("ka"),

    /**
     * Kongo
     */
    KONGO("kg"),

    /**
     * Kikuyu
     */
    KIKUYU("ki"),

    /**
     * Kwanyama
     */
    KWANYAMA("kj"),

    /**
     * Kazakh
     */
    KAZAKH("kk"),

    /**
     * Kalaallisut
     */
    KALAALLISUT("kl"),

    /**
     * Khmer
     */
    KHMER("km"),

    /**
     * Kannada
     */
    KANNADA("kn"),

    /**
     * Korean
     */
    KOREAN("ko"),

    /**
     * Kanuri
     */
    KANURI("kr"),

    /**
     * Kashmiri
     */
    KASHMIRI("ks"),

    /**
     * Kurdish
     */
    KURDISH("ku"),

    /**
     * Komi
     */
    KOMI("kv"),

    /**
     * Cornish
     */
    CORNISH("kw"),

    /**
     * Kyrgyz
     */
    KYRGYZ("ky"),

    /**
     * Latin
     */
    LATIN("la"),

    /**
     * Luxembourgish
     */
    LUXEMBOURGISH("lb"),

    /**
     * Ganda
     */
    GANDA("lg"),

    /**
     * Limburgish
     */
    LIMBURGISH("li"),

    /**
     * Lingala
     */
    LINGALA("ln"),

    /**
     * Lao
     */
    LAO("lo"),

    /**
     * Lithuanian
     */
    LITHUANIAN("lt"),

    /**
     * Luba-Katanga
     */
    LUBA_KATANGA("lu"),

    /**
     * Latvian
     */
    LATVIAN("lv"),

    /**
     * Malagasy
     */
    MALAGASY("mg"),

    /**
     * Marshallese
     */
    MARSHALLESE("mh"),

    /**
     * Māori
     */
    MĀORI("mi"),

    /**
     * Macedonian
     */
    MACEDONIAN("mk"),

    /**
     * Malayalam
     */
    MALAYALAM("ml"),

    /**
     * Mongolian
     */
    MONGOLIAN("mn"),

    /**
     * Marathi
     */
    MARATHI("mr"),

    /**
     * Malay
     */
    MALAY("ms"),

    /**
     * Maltese
     */
    MALTESE("mt"),

    /**
     * Burmese
     */
    BURMESE("my"),

    /**
     * Nauru
     */
    NAURU("na"),

    /**
     * Norwegian
     */
    NORWEGIAN("nb"),

    /**
     * Northern
     */
    NORTHERN_ND("nd"),

    /**
     * Nepali
     */
    NEPALI("ne"),

    /**
     * Ndonga
     */
    NDONGA("ng"),

    /**
     * Dutch
     */
    DUTCH("nl"),

    /**
     * Norwegian
     */
    NORWEGIAN_NN("nn"),

    /**
     * Norwegian
     */
    NORWEGIAN_NO("no"),

    /**
     * Southern
     */
    SOUTHERN_NR("nr"),

    /**
     * Navajo
     */
    NAVAJO("nv"),

    /**
     * Chichewa
     */
    CHICHEWA("ny"),

    /**
     * Occitan
     */
    OCCITAN("oc"),

    /**
     * Ojibwe
     */
    OJIBWE("oj"),

    /**
     * Oromo
     */
    OROMO("om"),

    /**
     * Oriya
     */
    ORIYA("or"),

    /**
     * Ossetian
     */
    OSSETIAN("os"),

    /**
     * Panjabi
     */
    PANJABI("pa"),

    /**
     * Pāli
     */
    PĀLI("pi"),

    /**
     * Polish
     */
    POLISH("pl"),

    /**
     * Pashto
     */
    PASHTO("ps"),

    /**
     * Portuguese
     */
    PORTUGUESE("pt"),

    /**
     * Quechua
     */
    QUECHUA("qu"),

    /**
     * Romansh
     */
    ROMANSH("rm"),

    /**
     * Kirundi
     */
    KIRUNDI("rn"),

    /**
     * Romanian
     */
    ROMANIAN("ro"),

    /**
     * Russian
     */
    RUSSIAN("ru"),

    /**
     * Kinyarwanda
     */
    KINYARWANDA("rw"),

    /**
     * Sanskrit
     */
    SANSKRIT("sa"),

    /**
     * Sardinian
     */
    SARDINIAN("sc"),

    /**
     * Sindhi
     */
    SINDHI("sd"),

    /**
     * Northern
     */
    NORTHERN_SE("se"),

    /**
     * Sango
     */
    SANGO("sg"),

    /**
     * Sinhala
     */
    SINHALA("si"),

    /**
     * Slovak
     */
    SLOVAK("sk"),

    /**
     * Slovenian
     */
    SLOVENIAN("sl"),

    /**
     * Shona
     */
    SHONA("sn"),

    /**
     * Somali
     */
    SOMALI("so"),

    /**
     * Albanian
     */
    ALBANIAN("sq"),

    /**
     * Serbian
     */
    SERBIAN("sr"),

    /**
     * Swati
     */
    SWATI("ss"),

    /**
     * Southern
     */
    SOUTHERN_ST("st"),

    /**
     * Sundanese
     */
    SUNDANESE("su"),

    /**
     * Swedish
     */
    SWEDISH("sv"),

    /**
     * Swahili
     */
    SWAHILI("sw"),

    /**
     * Tamil
     */
    TAMIL("ta"),

    /**
     * Telugu
     */
    TELUGU("te"),

    /**
     * Tajik
     */
    TAJIK("tg"),

    /**
     * Thai
     */
    THAI("th"),

    /**
     * Tigrinya
     */
    TIGRINYA("ti"),

    /**
     * Turkmen
     */
    TURKMEN("tk"),

    /**
     * Tagalog
     */
    TAGALOG("tl"),

    /**
     * Tswana
     */
    TSWANA("tn"),

    /**
     * Tonga
     */
    TONGA("to"),

    /**
     * Turkish
     */
    TURKISH("tr"),

    /**
     * Tsonga
     */
    TSONGA("ts"),

    /**
     * Tatar
     */
    TATAR("tt"),

    /**
     * Twi
     */
    TWI("tw"),

    /**
     * Tahitian
     */
    TAHITIAN("ty"),

    /**
     * Uyghur
     */
    UYGHUR("ug"),

    /**
     * Ukrainian
     */
    UKRAINIAN("uk"),

    /**
     * Urdu
     */
    URDU("ur"),

    /**
     * Uzbek
     */
    UZBEK("uz"),

    /**
     * Venda
     */
    VENDA("ve"),

    /**
     * Vietnamese
     */
    VIETNAMESE("vi"),

    /**
     * Volapük
     */
    VOLAPÜK("vo"),

    /**
     * Walloon
     */
    WALLOON("wa"),

    /**
     * Wolof
     */
    WOLOF("wo"),

    /**
     * Xhosa
     */
    XHOSA("xh"),

    /**
     * Yiddish
     */
    YIDDISH("yi"),

    /**
     * Yoruba
     */
    YORUBA("yo"),

    /**
     * Zhuang
     */
    ZHUANG("za"),

    /**
     * Chinese
     */
    CHINESE("zh"),

    /**
     * Zulu
     */
    ZULU("zu");

    /**
     * ISO 639-1 language code
     */
    private final String code;

    /**
     * Get iso 639-1 language code
     *
     * @return iso 639-1 language code
     */
    @JsonValue
    public String getCode() {
        return code;
    }

    /**
     * Finds enum value by iso code
     *
     * @param code iso 639-1 language code
     * @return found enum value
     */
    @JsonCreator
    public static LanguageCode fromCode(final String code) {
        return Stream.of(LanguageCode.values())
                .filter(mode -> Objects.equals(mode.code, code))
                .findFirst()
                .orElse(null);
    }
}
