package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;


import static org.hamcrest.MatcherAssert.assertThat;


@Component
public class DocConfirmAction extends BaseAction {


    public DocConfirmResponse docConfirm(
        UniqueID registerId,
        String postingGUID,
        String voidFlag,
        String docFacsimile,
        MenuItemList menuItemList,
        PaymentListType paymentList,
        TaxListType taxList
    ){
        DocConfirmRequest request = new DocConfirmRequest();

            request.setRegisterId(registerId);
            request.setPostingGUID(postingGUID);
            request.setVoidFlag(voidFlag);
            request.setDocFacsimile(docFacsimile);
            request.setMenuItemList(menuItemList);
            request.setPaymentList(paymentList);
            request.setTaxList(taxList);

        return (DocConfirmResponse) soapHelper.go(request);
    }











    public void checkResultStatus(DocConfirmResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }

/*
    public void checkResultPaymentAmount(PostPaymentResponse response, Double paymentAmount) {
        assertThat(
                Double.valueOf(response.getPaymentAmount()),
                CoreMatchers.equalTo(paymentAmount)
        );
    }



    public void checkResultInfo(PostPaymentResponse response, String expectedPaymentInfo) {
        assertThat(
                response.getPaymentInfo(),
                CoreMatchers.equalTo(expectedPaymentInfo)
        );
    }
*/



}
