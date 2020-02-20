package ru.hrs.lassd.club.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"data.properties"})
public class Data {

    @Value("${site_id}")                    public int siteId;
    @Value("${outlet_id}")                  public int outletID;

    @Value("${profile_last_name}")          public String profileLastName;
    @Value("${profile_first_name}")         public String profileFirstName;
    @Value("${profile_room}")               public int profileRoom;
    @Value("${profile_card}")               public int profileCard;
    @Value("${profile_magstripe}")          public String profileMagstripe;
    @Value("${profile_extra_magstripe}")    public String profileExtraMagstripe;
    @Value("${profile_mobile}")             public String profileMobile;
    @Value("${profile_key_code}")           public String profileKeyCode;
    @Value("${profile_key_number}")         public String profileKeyNumber;
    @Value("${profile_booking_id}")         public String profileBookingId;
    @Value("${profile_foreign_id}")         public String profileForeignId;
    @Value("${profile_ticket}")             public String profileTicket;


/*
    @Value("${count}")                          public int count;

    @Value("${card_id}")                        public int cardID;
    @Value("${card_magstripe}")                 public String cardMagstripe;
    @Value("${card_email}")                     public String cardEmail;
    @Value("${card_phone}")                     public String cardPhone;
    @Value("${card_password}")                  public String cardPassword;
    @Value("${card_type}")                      public String cardType;

    @Value("${therapist_id}")                   public int therapistID;
    @Value("${empl_magstripe}")                 public String emplMagstripe;
    @Value("${empl_username}")                  public String emplUsername;
    @Value("${empl_password}")                  public String emplPassword;

    @Value("${spa_package_id}")                 public int spaPackageID;
    @Value("${offer_id}")                       public int offerID;
    @Value("${offer_barcode}")                  public String offerBarcode;
    @Value("${class_id}")                       public int classID;
    @Value("${cancelled_class_id}")             public int cancelledClassID;
    @Value("${voucher_num}")                    public String voucherNum;

    @Value("${tender_id}")                      public int tenderID;
    @Value("${tender_name}")                    public String tenderName;
    @Value("${deposit_tender_id}")              public int depositTenderID;
    @Value("${deposit_tender_name}")            public String depositTenderName;
    @Value("${online_tender_id}")               public int onlineTenderID;
    @Value("${online_tender_name}")             public String onlineTenderName;
    @Value("${online_tender_token}")            public String onlineTenderToken;
    @Value("${online_tender_token_poor}")       public String onlineTenderTokenPoor;
    @Value("${online_tender_token_3ds}")        public String onlineTenderToken3Ds;
    @Value("${online_tender_token_poor_3ds}")   public String onlineTenderTokenPoor3Ds;
    @Value("${cardholder_name}")                public String cardholderName;
*/


    public Data(){}
}
