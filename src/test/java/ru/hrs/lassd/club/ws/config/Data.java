package ru.hrs.lassd.club.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@PropertySource({"data.properties"})
public class Data {

    @Value("${site_id}")                    public int siteId;
    @Value("${outlet_id}")                  public int outletID;
    @Value("${rvc_number}")                 public BigInteger rvcNumber;
    @Value("${ws_id}")                      public int wsId;

    @Value("${profile_last_name}")                      public String profileLastName;
    @Value("${profile_first_name}")                     public String profileFirstName;
    @Value("${profile_room}")                           public int profileRoom;
    @Value("${profile_card}")                           public int profileCard;
    @Value("${profile_magstripe}")                      public String profileMagstripe;
    @Value("${profile_extra_magstripe}")                public String profileExtraMagstripe;
    @Value("${profile_expired_magstripe}")              public String profileExpiredMagstripe;
    @Value("${profile_locked_magstripe}")               public String profileLockedMagstripe;
    @Value("${profile_mobile}")                         public String profileMobile;
    @Value("${profile_key_code}")                       public String profileKeyCode;
    @Value("${profile_key_number}")                     public String profileKeyNumber;
    @Value("${profile_booking_id}")                     public String profileBookingId;
    @Value("${profile_foreign_id}")                     public String profileForeignId;
    @Value("${profile_ticket}")                         public String profileTicket;
    @Value("${profile_voucher_amount}")                 public String profileVoucherAmount;
    @Value("${profile_voucher_amount_campaign}")        public String profileVoucherAmountCampaign;
    @Value("${profile_voucher_discount}")               public String profileVoucherDiscount;
    @Value("${profile_voucher_extra_items}")            public String profileVoucherExtraItems;
    @Value("${profile_voucher_inactive_extra_items}")   public String profileVoucherInactiveExtraItems;
    @Value("${profile_voucher_items_campaign}")         public String profileVoucherItemsCampaign;
    @Value("${profile_voucher_consumed}")               public String profileVoucherConsumed;
    @Value("${profile_voucher_expired}")                public String profileVoucherExpired;
    @Value("${profile_voucher_locked}")                 public String profileVoucherLocked;
    @Value("${profile_subscription}")                   public long profileSubscription;
    @Value("${profile_membership}")                     public long profileMembership;
    @Value("${profile_locker_number}")                  public String profileLockerNumber;

    @Value("${profile_card_slave}")         public int profileCardSlave;

    @Value("${employee_id}")                public int employeeId;
    @Value("${employee_name}")              public String employeeName;

    @Value("${mi_id}")                      public Long miId;
    @Value("${mi_name}")                    public String miName;
    @Value("${mi_price}")                   public Double miPrice;
    @Value("${mi_discount}")                public Double miDiscount;
    @Value("${mi_si}")                      public int miSI;
    @Value("${mi_fgrp}")                    public int miFGrp;

    @Value("${tender_id}")                  public int tenderId;
    @Value("${tender_name}")                public String tenderName;
    @Value("${deposit_tender_id}")          public int depositTenderId;
    @Value("${deposit_tender_name}")        public String depositTenderName;

    @Value("${tax_vat_id}")                 public int taxVATId;
    @Value("${tax_vat_name}")               public String taxVATName;
    @Value("${tax_vat_rate}")               public double taxVATRate;
    @Value("${tax_addon_id}")               public int taxAddonId;
    @Value("${tax_addon_name}")             public String taxAddonName;
    @Value("${tax_addon_rate}")             public double taxAddonRate;




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
