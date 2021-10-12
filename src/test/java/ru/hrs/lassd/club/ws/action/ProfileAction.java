package ru.hrs.lassd.club.ws.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.config.Data;
import ru.hrs.lassd.club.ws.schema.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Arrays;

@Component
public class ProfileAction {


    public Customer createCustomer(
            PersonName personName,
            String businessTitle,
            GovernmentIDList governmentIDList,
            XMLGregorianCalendar birthDate,
            Gender gender
    ) {
        Customer customer = new Customer();
        customer.setPersonName(personName);
        customer.setBusinessTitle(businessTitle);
        customer.setGovernmentIDList(governmentIDList);
        customer.setBirthDate(birthDate);
        customer.setGender(gender);
        return customer;
    }


    public PersonName createPersonName(
            String nameTitle,
            String firstName,
            String middleName,
            String lastName
    ) {
        return createPersonName(nameTitle, firstName, middleName, lastName, null, null, null);
    }

    public PersonName createPersonName(
            String nameTitle,
            String firstName,
            String middleName,
            String lastName,
            String nameSuffix,
            String familiarName,
            String nameOrdered
    ) {
        PersonName personName = new PersonName();
        personName.getNameTitle().add(nameTitle);
        personName.setFirstName(firstName);
        personName.getMiddleName().add(middleName);
        personName.setLastName(lastName);
        personName.getNameSuffix().add(nameSuffix);
        personName.setFamiliarName(familiarName);
        personName.setNameOrdered(nameOrdered);
        return personName;
    }


    public GovernmentIDList createGovernmentID(
            String documentType,
            String documentNumber,
            XMLGregorianCalendar effectiveDate,
            XMLGregorianCalendar expirationDate,
            String placeOfIssue,
            String countryOfIssue
    ) {
        GovernmentID governmentID = new GovernmentID();
        governmentID.setDocumentType(documentType);
        governmentID.setDocumentNumber(documentNumber);
        governmentID.setEffectiveDate(effectiveDate);
        governmentID.setExpirationDate(expirationDate);
        governmentID.setPlaceOfIssue(placeOfIssue);
        governmentID.setCountryOfIssue(countryOfIssue);
        GovernmentIDList governmentIDList = new GovernmentIDList();
        governmentIDList.getGovernmentID().add(governmentID);
        return governmentIDList;
    }


    public NameCreditCardList createNameCreditCard(
            UniqueIDList iDs,
            Integer displaySequence,
            Boolean primary,
            XMLGregorianCalendar inactiveDate,
            XMLGregorianCalendar insertDate,
            String insertUser,
            XMLGregorianCalendar updateDate,
            String updateUser
    ){
        NameCreditCard nameCreditCard = new NameCreditCard();
        nameCreditCard.setIDs(iDs);
        nameCreditCard.setDisplaySequence(displaySequence);
        nameCreditCard.setPrimary(primary);
        nameCreditCard.setInactiveDate(inactiveDate);
        nameCreditCard.setInsertDate(insertDate);
        nameCreditCard.setInsertUser(insertUser);
        nameCreditCard.setUpdateDate(updateDate);
        nameCreditCard.setUpdateUser(updateUser);
        NameCreditCardList creditCardList = new NameCreditCardList();
        creditCardList.getNameCreditCard().add(nameCreditCard);
        return creditCardList;
    }


    public NameAddressList createNameAddress(
            UniqueIDList iDs,
            Boolean primary
    ){
        return createNameAddress(iDs, null, primary, null, null, null, null, null);
    }

    public NameAddressList createNameAddress(
            UniqueIDList iDs,
            Integer displaySequence,
            Boolean primary,
            XMLGregorianCalendar inactiveDate,
            XMLGregorianCalendar insertDate,
            String insertUser,
            XMLGregorianCalendar updateDate,
            String updateUser
    ){
        NameAddress nameAddress = new NameAddress();
        nameAddress.setIDs(iDs);
        nameAddress.setDisplaySequence(displaySequence);
        nameAddress.setPrimary(primary);
        nameAddress.setInactiveDate(inactiveDate);
        nameAddress.setInsertDate(insertDate);
        nameAddress.setInsertUser(insertUser);
        nameAddress.setUpdateDate(updateDate);
        nameAddress.setUpdateUser(updateUser);
        NameAddressList nameAddressList = new NameAddressList();
        nameAddressList.getNameAddress().add(nameAddress);
        return nameAddressList;
    }


    public BlackList createBlackList(
            String value,
            BlackListFlag flag
    ){
        BlackList blackList = new BlackList();
        blackList.setValue(value);
        blackList.setFlag(flag);
        return blackList;
    }


    public NamePhoneList createNamePhone(
            UniqueIDList iDs,
            Boolean primary
    ){
        return createNamePhone(iDs, null, primary, null, null, null, null, null);
    }

    public NamePhoneList createNamePhone(
            UniqueIDList iDs,
            Integer displaySequence,
            Boolean primary,
            XMLGregorianCalendar inactiveDate,
            XMLGregorianCalendar insertDate,
            String insertUser,
            XMLGregorianCalendar updateDate,
            String updateUser
    ){
        NamePhone namePhone = new NamePhone();
        namePhone.setIDs(iDs);
        namePhone.setDisplaySequence(displaySequence);
        namePhone.setPrimary(primary);
        namePhone.setInactiveDate(inactiveDate);
        namePhone.setInsertDate(insertDate);
        namePhone.setInsertUser(insertUser);
        namePhone.setUpdateDate(updateDate);
        namePhone.setUpdateUser(updateUser);
        NamePhoneList namePhoneList = new NamePhoneList();
        namePhoneList.getNamePhone().add(namePhone);
        return namePhoneList;
    }


    public PreferenceList createPreference(
            DescriptiveText preferenceDescription,
            UniqueIDList iDs,
            String otherPreferenceType,
            String preferenceType,
            String preferenceValue,
            String resortCode,
            XMLGregorianCalendar inactiveDate,
            XMLGregorianCalendar insertDate,
            String insertUser,
            XMLGregorianCalendar updateDate,
            String updateUser
    ){
        Preference preference = new Preference();
        preference.setPreferenceDescription(preferenceDescription);
        preference.setIDs(iDs);
        preference.setOtherPreferenceType(otherPreferenceType);
        preference.setPreferenceType(preferenceType);
        preference.setPreferenceValue(preferenceValue);
        preference.setResortCode(resortCode);
        preference.setInactiveDate(inactiveDate);
        preference.setInsertDate(insertDate);
        preference.setInsertUser(insertUser);
        preference.setUpdateDate(updateDate);
        preference.setUpdateUser(updateUser);
        PreferenceList preferenceList = new PreferenceList();
        preferenceList.getPreference().add(preference);
        return preferenceList;
    }


    public NegotiatedRateList createNegotiated(
            String rateCode,
            int resortCode
    ){
        return createNegotiated(null, null, null, null, null, rateCode, resortCode, null, null, null, null, null);
    }

    public NegotiatedRateList createNegotiated(
            UniqueIDList iDs,
            XMLGregorianCalendar beginDate,
            String commissionCode,
            Integer displaySequence,
            XMLGregorianCalendar endDate,
            String rateCode,
            int resortCode,
            XMLGregorianCalendar inactiveDate,
            XMLGregorianCalendar insertDate,
            String insertUser,
            XMLGregorianCalendar updateDate,
            String updateUser
    ){
        NegotiatedRate negotiatedRate = new NegotiatedRate();
        negotiatedRate.setIDs(iDs);
        negotiatedRate.setBeginDate(beginDate);
        negotiatedRate.setCommissionCode(commissionCode);
        negotiatedRate.setDisplaySequence(displaySequence);
        negotiatedRate.setEndDate(endDate);
        negotiatedRate.setRateCode(rateCode);
        negotiatedRate.setResortCode(String.valueOf(resortCode));
        negotiatedRate.setInactiveDate(inactiveDate);
        negotiatedRate.setInactiveDate(inactiveDate);
        negotiatedRate.setInsertDate(insertDate);
        negotiatedRate.setInsertUser(insertUser);
        negotiatedRate.setUpdateDate(updateDate);
        negotiatedRate.setUpdateUser(updateUser);
        NegotiatedRateList negotiatedRateList = new NegotiatedRateList();
        negotiatedRateList.getNegotiatedRate().add(negotiatedRate);
        return negotiatedRateList;
    }

}
