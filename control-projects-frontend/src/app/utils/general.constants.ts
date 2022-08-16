export class GenericConstants {
  public static REGEX_TEXT_LATAM =
    '^[a-zA-Z0-9_\\-\\. áéíóúÁÉÍÓÚñÑäëïÖüÄËÏÖü]+$';
  public static REGEX_CC_COLOMBIA = '^((\\d{8})|(\\d{10})|(\\d{11})|(\\d{6}-\\d{5}))?$'
  public static REGEX_DATE_LATAM =
  '^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$';
  public static MAX_LENGTH_NAME = 70;
  public static MIN_LENGTH_NAME = 3;
  public static REGEX_ADDRESS_LATAM =
    '^[a-zA-Z0-9_\\-\\. áéíóúÁÉÍÓÚñÑäëïÖüÄËÏÖü#]+$';
  public static REGEX_PHONE_NUMBER =
    '^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$';
  public static MAX_LENGTH_PHONE = 18;
  public static MIN_LENGTH_PHONE = 10;
}
