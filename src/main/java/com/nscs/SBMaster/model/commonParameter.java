package com.nscs.SBMaster.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class commonParameter {

    // Total 48 Modules Till
    protected String g_sModules[] = { "N", "N", "N", "N", "N", "N", "N", "N",
            "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N",
            "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N", "N",
            "N", "N", "N", "N", "N", "N", "N", "N" ,"N", "N", "N", "N", "N",
            "N","N","N","N","N","N"};			//53 ( 0 -49)


    protected String gsParentCode, g_sBankId, g_sBankCode,ecsBankCode, mnuRequired;

    @JsonFormat(pattern = "MMM dd, yyyy")
    private LocalDate g_Date;

    protected String sBankHName = "", sBankEName = "";

    protected String sTrScrId, sClScrId, sCsScrId;

    protected String sTokenMst, sTokenMust, sTknStMust;

    protected String sCrNarr, sDocType, sAmtOnce, sDocDtlYN, sBirdView,
            sMemFlag;

    protected String sIscashAuto, sTransactionNo, sSepScroll, sVouAftInt,
            sIncDerFirst;


    protected int iBankCurrency;

    protected boolean bErrorFound;

    protected String sVoucherPrtOnline, sTokenYN, sEMIAtDisb, sMakerChecker,
            sLooseChequeReqd;

    protected double dFDCash, dPANReqdAmt, dWithLmtWs;

    protected int iRenDays;

    protected String sDrFirst, sVoucherType;

    protected int iHoliday;

    protected String sCprCyDate = "01/01/1900";

    // /////////////////****Added from
    // TableCpr***************************////////

    protected String sCheckVal, sCprRap, sDrCrTogeth, sChecksum, sDenom,
            sAdrCer, sCprNom;

    protected String sCprCaodLink, sCprChgFdInt, sCprFdIntPay, sCprNetting,
            sCprFdProvPay;

    protected String sCprAcNoGrp, sCprAcNoAct, sCprIntFromProv, sCprPratYrCl,
            sCprProvonoverDue;

    protected String sCprLoanAdjFd, sCprCursorAt, sCprLoginName, sCprGlFirst,
            sCprPayFees;

    protected String sCprVouol, sCprAccAllName, sCprAccAllAddress,
            sCprReportHeader, sCprBorNo;

    protected String sCprMinChqyn, sCprIntodFd, sCprTrnsOd, sCprIndins,
            sCprSecins, sCprFdPayMethod;

    protected String sCprTdSonProv, sCprHoliNtyn, sCprOdroi, sCprScrSheet,
            sCprTdsPronota;

    protected String sCprSiBelowMinBal, sCprBrnPrm, sCprIntwdClg, sCprAutoNpa,
            sCprIntFromProvdr;

    protected String sCprEmiAtDisb, sCprMemNo, sCprCalOver, sCprPassChqDet,
            sCprWorkOnClsDt;

    protected String sCprLoanDtl, sCprAutoLogout, sCprPreSanc,
            sCprServiceTaxPrd, sCprChkDigReqd;

    protected String sCprActCodeReqDinAcc, sCprGrpReqd, sCprDupstChg,
            sCprIncomeShorName;

    protected String sCprExpenShorName, sCprAssetShorName, sCprLiabShorName,
            sCprCliabShorName;

    protected String sCprCAssetShorName, sCprDupEmp;

    protected int iMonth;// sMonth ;

    protected int iPgEntry, iCourtMage, iCourtFage, iCprDeotries, iCprNoofDba,
            iCprChqExp, iCprNetHead;

    protected int iCprIncHead, iCprExpHead, iCprPassDigit, iCprIntodFdDays,
            iCprInDage, iCprLang3;

    protected int iCprSiheld, iCprSbHead, iCprDiffPswds, iCprAutoLogTime,
            iCprCessHead, iCprTdsPayHead;

    protected int iMajMale, iMajFemale, iMinMale, iMinFemale, iIntroMnth,
            iIntRound;

    protected int iCprPassDays,disablePeriod;

    protected double dMaxCashIt, dCprFdMaxDepMinor, cpr_tdsonamt, dCprVersion,
            dCprPtlr, dCprBrnLmt;

    protected double dCprMinroi, dCprIncentive, dCprServicetax, dCprTdsOnAmt;

    protected String sAuthorised;
    protected String sAccWisePrmAuthorised ;
    protected String sValueDateBeyondFromPeriod;
    protected int iValueDateBeyondFromMonth;
    protected String sFdFullAdjust ;
    protected int iNonWorkingDay ;
    protected String sIbUserIDCreationType ;
    protected String sFdPenalRoi ;
    protected String sInstStartType ;

    protected String sDprDenom="";
    protected String sDprCtoC="";
    protected String sDprCatoCa="";
    protected String sDormantAllow = "";
    protected double dCprRplr = 0.00;
    protected long lcprInterSolDrHead = 0 ;
    protected long lcprInterSolCrHead = 0 ;
    protected String sUntalliedBatchAllow = "";
    protected String sRemDefCat="";
    protected String sRdIntOnActualBal="";
    protected String cPMFdRoiChangeYN="N";
    protected String sRemSchAllow = "N" ;
    protected String ibrSummarised="Y" ;
    protected long ibrDoc=0 ;
    protected String bankCurCode="" ;
    protected String pbPrinType="E" ;
    protected String custAuth="Y" ;
    protected String sSpouceDetailYN="Y";
    protected long lForexTaxHead = 0;
    protected double dForexTaxPerCent = 0.0000;
    protected long lForexBalancingHead = 0;
    protected String pdcCheque="N";
    protected String fingerPrintMust="N";
    protected String lienTrfFull = "Y" ;
    protected String familyDetReq="";
    protected String introYn="";
    protected String denomAtVouAuth="";
    protected double vatTax=0.00;
    protected long vatTaxHead=0;
    protected double debitTax=0.00;
    protected long debitTaxHead=0;
    protected double debitTaxAmt=0;
    protected String isJointUser=""; //Ravi
    protected String otherIntroAcc="";
    protected String sCurrMultipleOf="";
    protected String bcfCntid="";
    protected String sCloseSingleRecieptFdAcc="N";
    protected String autoLoanRecovery="N" ;
    protected String authBatchBySingle="N";
    protected String yearDayInScroll="N";
    protected String tdsAtCust="N";
    protected double tdsAppAmt=0.00;
    protected String dpUpdDayEnd="N";
    protected String sBudgetPeriodcity="";
    protected int finYearStartMonth=4;
    protected String nicRequired="N" ;
    protected String indAcValueDt="N";
    protected String zeroRoi="N" ;
    protected int activeCurrencyCount=0;
    protected String intPostBetMon="N";
    protected int intPostday=25;
    protected String menumodeOnLogin="N";			//shailendra - common version
    protected long lockerAccHead = 0l ;
    protected String agnNo="";
    protected String agnPre="";
    protected String agnCollBy="H";
    protected String agnToken="N";
    protected int loanLinkCat = 0;
    protected String custeditsameusr="N";
    protected String prematfdroichng="N";
    protected String fileUploadYN="";
    protected String exlrpt="N";
    protected String cprCSEditYN = "N";
    protected String tempAccBefAuth="N" ;
    public static final int emiUpperRound = 10;
    protected String servicetaxhbal = "N"; // added by rjoshi
    public Double servicetaxround = 0.25;
    protected String maxbcDays="";
    protected String isAdrCerFirm="";
    protected String lockerOperationBy = "A";//new added by kapil
    protected String isPrintTr="N";//new added by shailendra
    protected String isPrintTrCopies="1";//new added by shailendra
    protected String isPrintCsRCopies="2";//new added by shailendra
    protected String isPrintCsPCopies="1";//new added by shailendra
    protected String sAuthoremrefress = "Y";
    protected String sLoanIntLienFdMat="";	// whether lien FD interest is to be transferred rto loan account or not
    protected String cprFdProvyn="";		// whether provisoing on Fd is to be made or not
    protected String cprAccName="";			// whether account name will be short name or long name
    protected String cprAutoNpaProv="";		// whether auto NPa provising or not
    protected String cprAnyDayRecovery="";	// whether any day recovery in laon account or specific day
    protected String tdsonOldInt= "" ; 		// whetehr TDS will be consider on earleir interest or only on this interest
    protected String sOccupationDetailYN="Y";
    protected String isStatWithOcdYn = "N";
    protected String isCtsAfLogYN="Y"; //new on 18-05-2010
    protected String serviceTaxYN="N"; //new on 18-05-2010
    protected String acnBackup= "N" ; // acnBackupOnCustDeathConfirm
    /*
     * Control Parameter
     */
    protected String loanCrEntFromOthBran = "N" ;
    protected int sExpDtInYear=1;
    protected String allowcreditMoreThanDemand="Y";
    protected String zeroAmtTrn="";
    protected String SysVouTrnTypeCash="TR";
    public double loanIntUpperRoundDigit=1;
    public String custOthIdMandatory = "Y"; /*Added by Dhiraj*/
    public String wdFormNumMandetory = "N";
    protected String sCprFdTrSunOd = "N";
    protected String sCprLoanAcCloseAtCr = "N";
    protected long lCprFdTrnSunHd = 0;
    public String skccopr = "C";
    protected String custwiselien= "N";
    protected String sCprInstRndType = "U";
    protected double dCprInstRndAmt = 0.00;
    protected String sCprVouOnCled = "N";// SSR on 22 Sept 2010
    protected String workPermAddress="N";
    protected String fastCustId="N";
    protected String unUseChqRetMust="N";//pg
    protected String authDetailReqd = "N";
    protected String clgserbrnYN= "N";
    protected String intValidPeriodOnDate = "A" ; // A - Account Op Date , C - Customer ID creation Date
    protected int numberofGurAcc= 99 ; // how many gurantee can be given by an account
    protected String scprsepnorpenalintyn = "Y";
    protected String sTrnsOdRd="";
    protected String ibtOnLine="N";
    protected String sFdOdRoiApplied = "";
    protected int wrongpswdtimes = 3 ;
    protected String unAuthCustAccMust="";
    protected long fdSundaryAdjHead = 0;//pg
    protected String resAddTlLmt="";
    protected String singleLangScreen="N";
    protected String sPinPhoneReq = "";
    protected String skuAutoGenerateYN="N";
    protected String cbrTallydndYN="";
    protected String cpr_autocalcmargin="N";
    protected String cpr_displayVersion="";
    protected String SameloanAcYN="N";
    protected String smemDtlReq ="N";
    protected String shoibrOnLine="N";
    protected long agnPreMatPrd=0l;
    protected long cprsTaxHead=0l;
    protected long cprDiscountHead=0l;
    protected long cprSupAccKid=0l;
    protected String  cprInvestProvYN="N";
    protected String voucherFingerMust="N" ;
    protected int minFinCapture=0 ;
    protected long cprsBuyerHead=0l;
    protected long cprbuyercreditlimithead=0l;
    protected String cprneftdualAuth ="N";
    protected String cpr_dcddall,cpr_autodayend;
    protected long cprwallethead=0l;
    protected long cprcslesshead = 0l;
    protected String cprLinkegShare="N";
    protected String sfdIntonoverduePeriod="Y";
    protected String cpr_ChargeGstInclude ="N";
    protected String cpr_segreegation="N";
    protected String cpr_GSTYN ="N";
    protected double cpr_GSTRate =0l;
    protected double cpr_CGSTRate =0l;
    protected double cpr_SGSTRate =0l;
    protected double cpr_IGSTRate =0l;
    protected long cpr_GSTHead =0l;
    protected long cpr_SGSTHead =0l;
    protected long cpr_CGSTHead =0l;
    protected long cpr_IGSTHead =0l;
    protected long cpr_GSTNettingHead =0l;
    protected String cprECSDrAccNo="0";

    protected double cpr_gstRevChr =0d;
    protected long cpr_gstRevhd =0l;
    protected double cpr_gstcompogsnChr =0d;
    protected long cpr_gstcompogsnhd =0l;
    protected long cpr_tdshd =0l;
    protected long cpr_ldincomehd =0l;
    protected long cpr_InputSGSTHead =0l;
    protected long cpr_InputCGSTHead =0l;
    protected long cpr_InputIGSTHead =0l;
    protected long cpr_InputrevChrHead =0l;
    protected double gstTdsAppAmt =0.00;
    protected double gstTdsPerc =0.00;
    protected long gstTdsHead =0l;
    protected long liabHead =43;
    protected long revenueHead =266;
    protected long goodsinTransit =291;		//Money in transit
    protected long advanceGST =300;		//Money in transit
    protected double cpr_CompositonRate =0l;
    protected int fundReq_startDay = 0;
    protected int fundReq_endDay = 0;
    protected int cpr_bankhead = 287 ;
    protected int cpr_cashhead = 289 ;
    protected int cpr_chequehead = 288 ;
    protected String  cpr_cenLimitAcc ="" ;
    protected String  cpr_cenLimitIFSC="" ;
    protected String  cprsoactivate="" ;
    protected String cpr_glheaddisplay ;
    protected String cpr_budgetreq = "N" ;
    protected String cpr_budgetinttrs="N" ;
    protected String auth_reqd="N" ;
    protected String packingSlipInSI="Y" ;
    protected String revChrSeparate="Y" ;		//PB - No separate Rev Charge , GSTN : separate Rev. Charge
    protected String venderChangeatPI="N" ;
    protected String chqValidate="N" ;
    protected long cpr_intincHead =0l;
    protected long cpr_intexpHead =0l;
    protected long cpr_discincHead =0l;
    protected long cpr_discexpHead =0l;
    protected String insPolicyNo = "" ;
    protected String tcsRecHead = "" ;
    protected String roundOffHead = "" ;
    protected String hoBranch = "" ;
    protected String cpr_headoffice = "" ;
    protected String scrapeHead = "0" ;
    protected String bgtBEsameRE = "N" ;
    protected String budgetCheck = "N" ;
    protected String loccheck = "N" ;
    protected String writeOffHead = "0" ;
    protected String IncomTaxHead = "0" ;
    protected String periodicity = "Y" ;
    protected String extendDay = "0" ;
    protected String valdModuleWiseConvDate="Y";
    protected String budgChkLevel="exp";

    public String getBudgChkLevel() {
        return budgChkLevel;
    }

    public void setBudgChkLevel(String budgChkLevel) {
        this.budgChkLevel = budgChkLevel;
    }
    public String getPeriodicity() {
        return periodicity;
    }

    public String getValdModuleWiseConvDate() {
        return valdModuleWiseConvDate;
    }

    public void setValdModuleWiseConvDate(String valdModuleWiseConvDate) {
        this.valdModuleWiseConvDate = valdModuleWiseConvDate;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getExtendDay() {
        return extendDay;
    }

    public void setExtendDay(String extendDay) {
        this.extendDay = extendDay;
    }

    public String getIncomTaxHead() {
        return IncomTaxHead;
    }

    public String getWriteOffHead() {
        return writeOffHead;
    }


    public String getMnuRequired() {
        return mnuRequired;
    }
    public void setMnuRequired(String mnuRequired) {
        this.mnuRequired = mnuRequired;
    }

    public String getCpr_headoffice() {
        return cpr_headoffice;
    }
    public long getCpr_intincHead() {
        return cpr_intincHead;
    }
    public long getCpr_intexpHead() {
        return cpr_intexpHead;
    }
    public long getCpr_discincHead() {
        return cpr_discincHead;
    }
    public long getCpr_discexpHead() {
        return cpr_discexpHead;
    }
    public String getCprECSDrAccNo() {
        return cprECSDrAccNo;
    }

    protected String cpr_GSTNettingBranchCode="";

    public String getCprLinkegShare() {
        return cprLinkegShare;
    }

    public long getCprwallethead() {
        return cprwallethead;
    }
    public String getCpr_dcddall() {
        return cpr_dcddall;
    }
    public String getCpr_autodayend() {
        return cpr_autodayend;
    }
    public long getCprbuyercreditlimithead() {
        return cprbuyercreditlimithead;
    }
    public String getCprInvestProvYN() {
        return cprInvestProvYN;
    }
    public long getCprSupAccKid() {
        return cprSupAccKid;
    }
    public long getAgnPreMatPrd() {
        return agnPreMatPrd;
    }
    public String getShoibrOnLine() {
        return shoibrOnLine;
    }
    public String getSmemDtlReq() {
        return smemDtlReq;
    }
    public String getCpr_autocalcmargin() {
        return cpr_autocalcmargin;
    }
    public String getCbrTallydndYN() {
        return cbrTallydndYN;
    }
    public void setCbrTallydndYN(String cbrTallydndYN) {
        this.cbrTallydndYN = cbrTallydndYN;
    }
    public String getSkuAutoGenerateYN() {
        return skuAutoGenerateYN;
    }
    public void setSkuAutoGenerateYN(String skuAutoGenerateYN) {
        this.skuAutoGenerateYN = skuAutoGenerateYN;
    }

    public long getFdSundaryAdjHead() {
        return fdSundaryAdjHead;
    }
    public String getUnAuthCustAccMust() {
        return unAuthCustAccMust;
    }

    public String getsFdOdRoiApplied() {
        return sFdOdRoiApplied;
    }
    public void setsFdOdRoiApplied(String sFdOdRoiApplied) {
        this.sFdOdRoiApplied = sFdOdRoiApplied;
    }
    public String getsTrnsOdRd() {
        return sTrnsOdRd;
    }
    public void setsTrnsOdRd(String sTrnsOdRd) {
        this.sTrnsOdRd = sTrnsOdRd;
    }
    public String getAuthDetailReqd() {
        return authDetailReqd;
    }
    public void setAuthDetailReqd(String authDetailReqd) {
        this.authDetailReqd = authDetailReqd;
    }
    public String getSCprVouOnCled() {
        return sCprVouOnCled;
    }
    public String getSCprInstRndType() {
        return sCprInstRndType;
    }
    public double getDCprInstRndAmt() {
        return dCprInstRndAmt;
    }
    public String getCustwiselien() {
        return custwiselien;
    }
    public String getsCprFdTrSunOd() {
        return sCprFdTrSunOd;
    }
    public String getsCprLoanAcCloseAtCr() {
        return sCprLoanAcCloseAtCr;
    }
    public long getlCprFdTrnSunHd() {
        return lCprFdTrnSunHd;
    }
    public String getZeroAmtTrn() {
        return zeroAmtTrn;
    }
    public int getSExpDtInYear() {
        return sExpDtInYear;
    }
    public String getIsPrintCsPCopies() {
        return isPrintCsPCopies;
    }
    public String getIsPrintCsRCopies() {
        return isPrintCsRCopies;
    }
    public String getIsPrintTrCopies() {
        return isPrintTrCopies;
    }
    public String getIsPrintTr() {
        return isPrintTr;
    }
    public String getLockerOperationBy(){
        return lockerOperationBy;
    }
    public String getMaxbcDays() {
        return maxbcDays;
    }
    public int getLoanLinkCat() { //vijay
        return loanLinkCat;
    }
    public long getLockerAccHead() {
        return lockerAccHead;
    }
    public String getsCloseSingleRecieptFdAcc() {
        return sCloseSingleRecieptFdAcc;
    }
    public String getOtherIntroAcc() {
        return otherIntroAcc;
    }
    public String getIsJointUser() {
        return isJointUser;
    }
    public String getFamilyDetReq() {
        return familyDetReq;
    }
    public String getPdcCheque() {
        return pdcCheque;
    }

    public String getSSpouceDetailYN() {
        return sSpouceDetailYN;
    }

    public String getSRemSchAllow() {
        return sRemSchAllow;
    }

    /**
     * ****************************************;
     * ***************************************
     */
    /**
     * @return Returns the bErrorFound.
     */
    public boolean isBErrorFound() {
        return bErrorFound;
    }

    /**
     * @return Returns the cpr_tdsonamt.
     */
    public double getCpr_tdsonamt() {
        return cpr_tdsonamt;
    }

    /**
     * @return Returns the dCprBrnLmt.
     */
    public double getDCprBrnLmt() {
        return dCprBrnLmt;
    }

    /**
     * @return Returns the dCprFdMaxDepMinor.
     */
    public double getDCprFdMaxDepMinor() {
        return dCprFdMaxDepMinor;
    }

    /**
     * @return Returns the dCprIncentive.
     */
    public double getDCprIncentive() {
        return dCprIncentive;
    }

    /**
     * @return Returns the dCprMinroi.
     */
    public double getDCprMinroi() {
        return dCprMinroi;
    }

    /**
     * @return Returns the dCprPtlr.
     */
    public double getDCprPtlr() {
        return dCprPtlr;
    }

    public double getDCprRplr() {
        return dCprRplr;
    }

    /**
     * @return Returns the dCprServicetax.
     */
    public double getDCprServicetax() {
        return dCprServicetax;
    }

    /**
     * @return Returns the dCprTdsOnAmt.
     */
    public double getDCprTdsOnAmt() {
        return dCprTdsOnAmt;
    }

    /**
     * @return Returns the dCprVersion.
     */
    public double getDCprVersion() {
        return dCprVersion;
    }

    /**
     * @return Returns the dFDCash.
     */
    public double getDFDCash() {
        return dFDCash;
    }

    /**
     * @return Returns the dMaxCashIt.
     */
    public double getDMaxCashIt() {
        return dMaxCashIt;
    }

    /**
     * @return Returns the dPANReqdAmt.
     */
    public double getDPANReqdAmt() {
        return dPANReqdAmt;
    }

    /**
     * @return Returns the dWithLmtWs.
     */
    public double getDWithLmtWs() {
        return dWithLmtWs;
    }

    /**
     * @return Returns the g_Date.
     */
    public LocalDate getG_Date() {
        return g_Date;
    }

    public void setG_Date(LocalDate g_Date) {
        this.g_Date = g_Date;
    }

    /**
     * @return Returns the g_sBankCode.
     */
    public String getg_sBankCode() {
        return g_sBankCode;
    }

    /**
     * @return Returns the g_sBankId.
     */
    public String getg_sBankId() {
        return g_sBankId;
    }

    /**
     * @return Returns the g_sModules.
     */
    public String[] getg_sModules() {
        return g_sModules;
    }

    /**
     * @return Returns the gsParentCode.
     */
    public String getgsParentCode() {
        return gsParentCode;
    }

    public String getsBankHName(){
        return sBankHName;
    }

    public String getsBankEName(){
        return sBankEName;
    }
    /**
     * @return Returns the iBankCurrency.
     */
    public int getiBankCurrency() {
        return iBankCurrency;
    }

    /**
     * @return Returns the iCourtFage.
     */
    public int getiCourtFage() {
        return iCourtFage;
    }

    /**
     * @return Returns the iCourtMage.
     */
    public int getiCourtMage() {
        return iCourtMage;
    }

    /**
     * @return Returns the iCprAutoLogTime.
     */
    public int getiCprAutoLogTime() {
        return iCprAutoLogTime;
    }

    /**
     * @return Returns the iCprCessHead.
     */
    public int getiCprCessHead() {
        return iCprCessHead;
    }

    /**
     * @return Returns the iCprChqExp.
     */
    public int getiCprChqExp() {
        return iCprChqExp;
    }

    /**
     * @return Returns the iCprDeotries.
     */
    public int getiCprDeotries() {
        return iCprDeotries;
    }

    /**
     * @return Returns the iCprDiffPswds.
     */
    public int getiCprDiffPswds() {
        return iCprDiffPswds;
    }

    /**
     * @return Returns the iCprExpHead.
     */
    public int getiCprExpHead() {
        return iCprExpHead;
    }

    /**
     * @return Returns the iCprIncHead.
     */
    public int getiCprIncHead() {
        return iCprIncHead;
    }

    /**
     * @return Returns the iCprInDage.
     */
    public int getiCprInDage() {
        return iCprInDage;
    }

    /**
     * @return Returns the iCprIntodFdDays.
     */
    public int getiCprIntodFdDays() {
        return iCprIntodFdDays;
    }

    /**
     * @return Returns the iCprLang3.
     */
    public int getiCprLang3() {
        return iCprLang3;
    }

    /**
     * @return Returns the iCprNetHead.
     */
    public int getiCprNetHead() {
        return iCprNetHead;
    }

    /**
     * @return Returns the iCprNoofDba.
     */
    public int getiCprNoofDba() {
        return iCprNoofDba;
    }

    /**
     * @return Returns the iCprPassDays.
     */
    public int getiCprPassDays() {
        return iCprPassDays;
    }

    /**
     * @return Returns the iCprPassDigit.
     */
    public int getiCprPassDigit() {
        return iCprPassDigit;
    }

    /**
     * @return Returns the iCprSbHead.
     */
    public int getiCprSbHead() {
        return iCprSbHead;
    }

    /**
     * @return Returns the iCprSiheld.
     */
    public int getiCprSiheld() {
        return iCprSiheld;
    }

    /**
     * @return Returns the iCprTdsPayHead.
     */
    public int getiCprTdsPayHead() {
        return iCprTdsPayHead;
    }

    /**
     * @return Returns the iHoliday.
     */
    public int getiHoliday() {
        return iHoliday;
    }

    /**
     * @return Returns the iIntroMnth.
     */
    public int getiIntroMnth() {
        return iIntroMnth;
    }

    /**
     * @return Returns the iIntRound.
     */
    public int getiIntRound() {
        return iIntRound;
    }

    /**
     * @return Returns the iMajFemale.
     */
    public int getiMajFemale() {
        return iMajFemale;
    }

    /**
     * @return Returns the iMajMale.
     */
    public int getiMajMale() {
        return iMajMale;
    }

    /**
     * @return Returns the iMinFemale.
     */
    public int getiMinFemale() {
        return iMinFemale;
    }

    /**
     * @return Returns the iMinMale.
     */
    public int getiMinMale() {
        return iMinMale;
    }

    /**
     * @return Returns the iPgEntry.
     */
    public int getiPgEntry() {
        return iPgEntry;
    }

    /**
     * @return Returns the iRenDays.
     */
    public int getiRenDays() {
        return iRenDays;
    }

    /**
     * @return Returns the sAdrCer.
     */
    public String getsAdrCer() {
        return sAdrCer;
    }

    /**
     * @return Returns the sAmtOnce.
     */
    public String getsAmtOnce() {
        return sAmtOnce;
    }

    /**
     * @return Returns the sBirdView.
     */
    public String getsBirdView() {
        return sBirdView;
    }

    /**
     * @return Returns the sChecksum.
     */
    public String getsChecksum() {
        return sChecksum;
    }

    /**
     * @return Returns the sCheckVal.
     */
    public String getsCheckVal() {
        return sCheckVal;
    }

    /**
     * @return Returns the sClScrId.
     */
    public String getsClScrId() {
        return sClScrId;
    }

    /**
     * @return Returns the sCprAccAllAddress.
     */
    public String getsCprAccAllAddress() {
        return sCprAccAllAddress;
    }

    /**
     * @return Returns the sCprAccAllName.
     */
    public String getsCprAccAllName() {
        return sCprAccAllName;
    }

    /**
     * @return Returns the sCprAcNoAct.
     */
    public String getsCprAcNoAct() {
        return sCprAcNoAct;
    }

    /**
     * @return Returns the sCprAcNoGrp.
     */
    public String getsCprAcNoGrp() {
        return sCprAcNoGrp;
    }

    /**
     * @return Returns the sCprActCodeReqDinAcc.
     */
    public String getsCprActCodeReqDinAcc() {
        return sCprActCodeReqDinAcc;
    }

    /**
     * @return Returns the sCprAssetShorName.
     */
    public String getsCprAssetShorName() {
        return sCprAssetShorName;
    }

    /**
     * @return Returns the sCprAutoLogout.
     */
    public String getsCprAutoLogout() {
        return sCprAutoLogout;
    }

    /**
     * @return Returns the sCprAutoNpa.
     */
    public String getsCprAutoNpa() {
        return sCprAutoNpa;
    }

    /**
     * @return Returns the sCprBorNo.
     */
    public String getsCprBorNo() {
        return sCprBorNo;
    }

    /**
     * @return Returns the sCprBrnPrm.
     */
    public String getsCprBrnPrm() {
        return sCprBrnPrm;
    }

    /**
     * @return Returns the sCprCalOver.
     */
    public String getsCprCalOver() {
        return sCprCalOver;
    }

    /**
     * @return Returns the sCprCaodLink.
     */
    public String getsCprCaodLink() {
        return sCprCaodLink;
    }

    /**
     * @return Returns the sCprCAssetShorName.
     */
    public String getsCprCAssetShorName() {
        return sCprCAssetShorName;
    }

    /**
     * @return Returns the sCprChgFdInt.
     */
    public String getsCprChgFdInt() {
        return sCprChgFdInt;
    }

    /**
     * @return Returns the sCprChkDigReqd.
     */
    public String getsCprChkDigReqd() {
        return sCprChkDigReqd;
    }

    /**
     * @return Returns the sCprCliabShorName.
     */
    public String getsCprCliabShorName() {
        return sCprCliabShorName;
    }

    /**
     * @return Returns the sCprCursorAt.
     */
    public String getsCprCursorAt() {
        return sCprCursorAt;
    }

    /**
     * @return Returns the sCprCyDate.
     */
    public String getsCprCyDate() {
        return sCprCyDate;
    }

    /**
     * @return Returns the sCprDupEmp.
     */
    public String getsCprDupEmp() {
        return sCprDupEmp;
    }

    /**
     * @return Returns the sCprDupstChg.
     */
    public String getsCprDupstChg() {
        return sCprDupstChg;
    }

    /**
     * @return Returns the sCprEmiAtDisb.
     */
    public String getsCprEmiAtDisb() {
        return sCprEmiAtDisb;
    }

    /**
     * @return Returns the sCprExpenShorName.
     */
    public String getsCprExpenShorName() {
        return sCprExpenShorName;
    }

    /**
     * @return Returns the sCprFdIntPay.
     */
    public String getsCprFdIntPay() {
        return sCprFdIntPay;
    }

    /**
     * @return Returns the sCprFdPayMethod.
     */
    public String getsCprFdPayMethod() {
        return sCprFdPayMethod;
    }

    /**
     * @return Returns the sCprFdProvPay.
     */
    public String getsCprFdProvPay() {
        return sCprFdProvPay;
    }

    /**
     * @return Returns the sCprGlFirst.
     */
    public String getsCprGlFirst() {
        return sCprGlFirst;
    }

    /**
     * @return Returns the sCprGrpReqd.
     */
    public String getsCprGrpReqd() {
        return sCprGrpReqd;
    }

    /**
     * @return Returns the sCprHoliNtyn.
     */
    public String getsCprHoliNtyn() {
        return sCprHoliNtyn;
    }

    /**
     * @return Returns the sCprIncomeShorName.
     */
    public String getsCprIncomeShorName() {
        return sCprIncomeShorName;
    }

    /**
     * @return Returns the sCprIndins.
     */
    public String getsCprIndins() {
        return sCprIndins;
    }

    /**
     * @return Returns the sCprIntFromProv.
     */
    public String getsCprIntFromProv() {
        return sCprIntFromProv;
    }

    /**
     * @return Returns the sCprIntFromProvdr.
     */
    public String getsCprIntFromProvdr() {
        return sCprIntFromProvdr;
    }

    /**
     * @return Returns the sCprIntodFd.
     */
    public String getsCprIntodFd() {
        return sCprIntodFd;
    }

    /**
     * @return Returns the sCprIntwdClg.
     */
    public String getsCprIntwdClg() {
        return sCprIntwdClg;
    }

    /**
     * @return Returns the sCprLiabShorName.
     */
    public String getsCprLiabShorName() {
        return sCprLiabShorName;
    }

    /**
     * @return Returns the sCprLoanAdjFd.
     */
    public String getsCprLoanAdjFd() {
        return sCprLoanAdjFd;
    }

    /**
     * @return Returns the sCprLoanDtl.
     */
    public String getsCprLoanDtl() {
        return sCprLoanDtl;
    }

    /**
     * @return Returns the sCprLoginName.
     */
    public String getsCprLoginName() {
        return sCprLoginName;
    }

    /**
     * @return Returns the sCprMemNo.
     */
    public String getsCprMemNo() {
        return sCprMemNo;
    }

    /**
     * @return Returns the sCprMinChqyn.
     */
    public String getsCprMinChqyn() {
        return sCprMinChqyn;
    }

    /**
     * @return Returns the sCprNetting.
     */
    public String getsCprNetting() {
        return sCprNetting;
    }

    /**
     * @return Returns the sCprNom.
     */
    public String getsCprNom() {
        return sCprNom;
    }

    /**
     * @return Returns the sCprOdroi.
     */
    public String getsCprOdroi() {
        return sCprOdroi;
    }

    /**
     * @return Returns the sCprPassChqDet.
     */
    public String getsCprPassChqDet() {
        return sCprPassChqDet;
    }

    /**
     * @return Returns the sCprPayFees.
     */
    public String getsCprPayFees() {
        return sCprPayFees;
    }

    /**
     * @return Returns the sCprPratYrCl.
     */
    public String getsCprPratYrCl() {
        return sCprPratYrCl;
    }

    /**
     * @return Returns the sCprPreSanc.
     */
    public String getsCprPreSanc() {
        return sCprPreSanc;
    }

    /**
     * @return Returns the sCprProvonoverDue.
     */
    public String getsCprProvonoverDue() {
        return sCprProvonoverDue;
    }

    /**
     * @return Returns the sCprRap.
     */
    public String getsCprRap() {
        return sCprRap;
    }

    /**
     * @return Returns the sCprReportHeader.
     */
    public String getsCprReportHeader() {
        return sCprReportHeader;
    }

    /**
     * @return Returns the sCprScrSheet.
     */
    public String getsCprScrSheet() {
        return sCprScrSheet;
    }

    /**
     * @return Returns the sCprSecins.
     */
    public String getsCprSecins() {
        return sCprSecins;
    }

    /**
     * @return Returns the sCprServiceTaxPrd.
     */
    public String getsCprServiceTaxPrd() {
        return sCprServiceTaxPrd;
    }

    /**
     * @return Returns the sCprSiBelowMinBal.
     */
    public String getsCprSiBelowMinBal() {
        return sCprSiBelowMinBal;
    }

    /**
     * @return Returns the sCprTdSonProv.
     */
    public String getsCprTdSonProv() {
        return sCprTdSonProv;
    }

    /**
     * @return Returns the sCprTdsPronota.
     */
    public String getsCprTdsPronota() {
        return sCprTdsPronota;
    }

    /**
     * @return Returns the sCprTrnsOd.
     */
    public String getsCprTrnsOd() {
        return sCprTrnsOd;
    }

    /**
     * @return Returns the sCprVouol.
     */
    public String getsCprVouol() {
        return sCprVouol;
    }

    /**
     * @return Returns the sCprWorkOnClsDt.
     */
    public String getsCprWorkOnClsDt() {
        return sCprWorkOnClsDt;
    }

    /**
     * @return Returns the sCrNarr.
     */
    public String getsCrNarr() {
        return sCrNarr;
    }

    /**
     * @return Returns the sCsScrId.
     */
    public String getsCsScrId() {
        return sCsScrId;
    }

    /**
     * @return Returns the sDenom.
     */
    public String getsDenom() {
        return sDenom;
    }

    /**
     * @return Returns the sDocDtlYN.
     */
    public String getsDocDtlYN() {
        return sDocDtlYN;
    }

    /**
     * @return Returns the sDocType.
     */
    public String getsDocType() {
        return sDocType;
    }

    /**
     * @return Returns the sDrCrTogeth.
     */
    public String getsDrCrTogeth() {
        return sDrCrTogeth;
    }

    /**
     * @return Returns the sDrFirst.
     */
    public String getsDrFirst() {
        return sDrFirst;
    }

    /**
     * @return Returns the sEMIAtDisb.
     */
    public String getsEMIAtDisb() {
        return sEMIAtDisb;
    }

    /**
     * @return Returns the sIncDerFirst.
     */
    public String getsIncDerFirst() {
        return sIncDerFirst;
    }

    /**
     * @return Returns the sIscashAuto.
     */
    public String getsIscashAuto() {
        return sIscashAuto;
    }

    /**
     * @return Returns the sLooseChequeReqd.
     */
    public String getsLooseChequeReqd() {
        return sLooseChequeReqd;
    }

    /**
     * @return Returns the sMakerChecker.
     */
    public String getsMakerChecker() {
        return sMakerChecker;
    }

    /**
     * @return Returns the sMemFlag.
     */
    public String getsMemFlag() {
        return sMemFlag;
    }


    /**
     * @return Returns the sMonth.
     */
    public int getsMonth() {
        // return sMonth;
        return iMonth;
    }

    /**
     * @return Returns the sSepScroll.
     */
    public String getsSepScroll() {
        return sSepScroll;
    }

    /**
     * @return Returns the sTknStMust.
     */
    public String getsTknStMust() {
        return sTknStMust;
    }

    /**
     * @return Returns the sTokenMst.
     */
    public String getsTokenMst() {
        return sTokenMst;
    }

    /**
     * @return Returns the sTokenMust.
     */
    public String getsTokenMust() {
        return sTokenMust;
    }

    /**
     * @return Returns the sTokenYN.
     */
    public String getsTokenYN() {
        return sTokenYN;
    }

    /**
     * @return Returns the sTransactionNo.
     */
    public String getsTransactionNo() {
        return sTransactionNo;
    }

    /**
     * @return Returns the sTrScrId.
     */
    public String getsTrScrId() {
        return sTrScrId;
    }

    /**
     * @return Returns the sVouAftInt.
     */
    public String getsVouAftInt() {
        return sVouAftInt;
    }

    /**
     * @return Returns the sVoucherPrtOnline.
     */
    public String getsVoucherPrtOnline() {
        return sVoucherPrtOnline;
    }

    /**
     * @return Returns the sVoucherType.
     */
    public String getsVoucherType() {
        return sVoucherType;
    }

    /**
     * @return Returns the sAuthorized.
     */
    public String getsAuthorised() {
        return sAuthorised;
    }

    public String getsValueDateBeyondFromPeriod() {
        return sValueDateBeyondFromPeriod ;
    }

    public int getiValueDateBeyondFromMonth() {
        return iValueDateBeyondFromMonth ;
    }
    public String getsAccWisePrmAuthorised() {
        return sAccWisePrmAuthorised ;
    }

    public int getiRoundAmt() {
        return 2 ;
    }

    public int getiNonWorkingDay() {
        return iNonWorkingDay;
    }

    public String getsFdFullAdjust() {
        return sFdFullAdjust;
    }

    public String getsIbUserIDCreationType() {
        return sIbUserIDCreationType;
    }
    public String getsFdPenalRoi() {
        return sFdPenalRoi ;
    }
    /**
     * @return String sInstStartType.
     */
    public String getsInstStartType() {
        return sInstStartType;
    }

    public String getSDprDenom() {
        return sDprDenom;
    }
    public String getSDprCtoC(){
        return sDprCtoC;
    }
    public String getSDprCatoCa(){
        return sDprCatoCa;
    }

    public String getSDormantAllow() {
        return sDormantAllow;
    }

    public long getLcprInterSolCrHead() {
        return lcprInterSolCrHead;
    }

    public long getLcprInterSolDrHead() {
        return lcprInterSolDrHead;
    }

    public String getSUntalliedBatchAllow() {
        return sUntalliedBatchAllow;
    }

    public String getSRemDefCat() {
        return sRemDefCat;
    }

    public String getSRdIntOnActualBal() {
        return sRdIntOnActualBal;
    }

    public String getcPMFdRoiChangeYN() {
        return cPMFdRoiChangeYN;
    }

    public String getIbrSummarised() {
        return ibrSummarised;
    }

    public long getIbrDoc() {
        return ibrDoc;
    }

    public String getBankCurCode() {
        return bankCurCode;
    }

    public void setBankCurCode(String bankCurCode) {
        this.bankCurCode = bankCurCode;
    }

    public String getCustAuth() {
        return custAuth;
    }

    public String getPbPrinType() {
        return pbPrinType;
    }

    public double getdForexTaxPerCent() {
        return dForexTaxPerCent;
    }

    public void setdForexTaxPerCent(double forexTaxPerCent) {
        dForexTaxPerCent = forexTaxPerCent;
    }

    public long getlForexBalancingHead() {
        return lForexBalancingHead;
    }

    public void setlForexBalancingHead(long forexBalancingHead) {
        lForexBalancingHead = forexBalancingHead;
    }

    public long getlForexTaxHead() {
        return lForexTaxHead;
    }
    public void setlForexTaxHead(long forexTaxHead) {
        lForexTaxHead = forexTaxHead;
    }

    public String getFingerPrintMust() {
        return fingerPrintMust;
    }

    public int getDisablePeriod() {
        return disablePeriod;
    }

    public String getLienTrfFull() {
        return lienTrfFull;
    }
    public double getDebitTax() {
        return debitTax;
    }
    public double getDebitTaxAmt() {
        return debitTaxAmt;
    }
    public long getDebitTaxHead() {
        return debitTaxHead;
    }
    public String getDenomAtVouAuth() {
        return denomAtVouAuth;
    }
    public String getIntroYn() {
        return introYn;
    }
    public double getVatTax() {
        return vatTax;
    }
    public long getVatTaxHead() {
        return vatTaxHead;
    }
    public String getSCurrMultipleOf() {
        return sCurrMultipleOf;
    }
    public String getBcfCntid() {
        return bcfCntid;
    }
    public String getAutoLoanRecovery() {
        return autoLoanRecovery;
    }
    public String getAuthBatchBySingle() {
        return authBatchBySingle;
    }

    public String getYearDayInScroll() {
        return yearDayInScroll;
    }
    public double getTdsAppAmt() {
        return tdsAppAmt;
    }
    public String getTdsAtCust() {
        return tdsAtCust;
    }
    public String getDpUpdDayEnd() {
        return dpUpdDayEnd;
    }
    public String getSBudgetPeriodcity() {
        return sBudgetPeriodcity;
    }
    public int getFinYearStartMonth() {
        return finYearStartMonth;
    }
    public String getNicRequired() {
        return nicRequired;
    }
    public String getIndAcValueDt() {
        return indAcValueDt;
    }
    public String getZeroRoi() {
        return zeroRoi;
    }
    public int getActiveCurrencyCount() {
        return activeCurrencyCount;
    }
    public void setActiveCurrencyCount(int activeCurrencyCount) {
        this.activeCurrencyCount = activeCurrencyCount;
    }
    public String getIntPostBetMon() {
        return intPostBetMon;
    }
    public int getIntPostday() {
        return intPostday;
    }
    public String getMenumodeOnLogin() {
        return menumodeOnLogin;
    }

    public String getAgnNo() {
        return agnNo;
    }

    public String getAgnPre() {
        return agnPre;
    }

    public String getAgnCollBy() {
        return agnCollBy;
    }

    public String getAgnToken() {
        return agnToken;
    }
    public String getCusteditsameusr() {
        return custeditsameusr;
    }
    public String getPrematfdroichng() {
        return prematfdroichng;
    }
    public String getFileUploadYN() {
        return fileUploadYN;
    }
    public String getExlrpt() {
        return exlrpt;
    }
    public String getCprCSEditYN() {
        return cprCSEditYN;
    }
    public String getTempAccBefAuth() {
        return tempAccBefAuth;
    }
    public static int getEmiUpperRound() {
        return emiUpperRound;
    }
    public String getServicetaxhbal() {
        return servicetaxhbal;
    }
    public Double getServicetaxround() {
        return servicetaxround;
    }
    public String getIsAdrCerFirm() {
        return isAdrCerFirm;
    }
    public String getsAuthoremrefress() {
        return sAuthoremrefress;
    }
    public String getLoanCrEntFromOthBran() {
        return loanCrEntFromOthBran;
    }
    public String getSLoanIntLienFdMat(){
        return sLoanIntLienFdMat;
    }
    public String getCprFdProvyn(){
        return cprFdProvyn;
    }
    public String getCprAccName(){
        return cprAccName;
    }
    public String getCprAutoNpaProv(){
        return cprAutoNpaProv;
    }
    public String getCprAnyDayRecovery(){
        return cprAnyDayRecovery;
    }
    public String getTdsonOldInt() {
        return tdsonOldInt;
    }
    public String getSOccupationDetailYN() {
        return sOccupationDetailYN;
    }
    public String getIsStatWithOcdYn() {
        return isStatWithOcdYn;
    }
    public String getServiceTaxYN() {
        return serviceTaxYN;
    }
    public String getIsCtsAfLogYN() {
        return isCtsAfLogYN;
    }
    public String getAllowcreditMoreThanDemand() {
        return allowcreditMoreThanDemand;
    }
    public String getAcnBackup(){
        return acnBackup;
    }
    public String getSysVouTrnTypeCash() {
        return SysVouTrnTypeCash;
    }
    public double getLoanIntUpperRoundDigit() {
        return loanIntUpperRoundDigit;
    }
    public String getCustOthIdMandatory() {
        return custOthIdMandatory;
    }
    public String getWdFormNumMandetory() {
        return wdFormNumMandetory;
    }
    public String getSkccopr() {
        return skccopr;
    }
    public String getWorkPermAddress() {
        return workPermAddress;
    }
    public String getFastCustId() {
        return fastCustId;
    }
    public String getUnUseChqRetMust() {
        return unUseChqRetMust;
    }
    public String getClgserbrnYN() {
        return clgserbrnYN;
    }
    public String getIntValidPeriodOnDate() {
        return intValidPeriodOnDate;
    }
    public int getNumberofGurAcc() {
        return numberofGurAcc;
    }
    public String getScprsepnorpenalintyn() {
        return scprsepnorpenalintyn;
    }
    public String getIbtOnLine() {
        return ibtOnLine;
    }
    public int getWrongpswdtimes() {
        return wrongpswdtimes;
    }
    public String getResAddTlLmt() {
        return resAddTlLmt;
    }
    public String getSingleLangScreen() {
        return singleLangScreen;
    }
    public String getSPinPhoneReq() {
        return sPinPhoneReq;
    }

    protected String execLiqdYN="N"; //Added for Protested Marking
    public String getExecLiqdYN() {
        return execLiqdYN;
    }
    protected String sChkPreRoiOnFDPreMatRenw = "";

    public String getsChkPreRoiOnFDPreMatRenw() {
        return sChkPreRoiOnFDPreMatRenw;
    }
    public void setsChkPreRoiOnFDPreMatRenw(String sChkPreRoiOnFDPreMatRenw) {
        this.sChkPreRoiOnFDPreMatRenw = sChkPreRoiOnFDPreMatRenw;
    }

    protected long sBankAccount=0;
    public long getsBankAccount() {
        return sBankAccount;
    }
    protected String sBankTrans = "N";
    public String getsBankTrans(){
        return sBankTrans;
    }
    public String getCpr_displayVersion(){
        return cpr_displayVersion;
    }
    public String getEcsBankCode() {
        return ecsBankCode;
    }
    public String getSameloanAcYN() {
        return SameloanAcYN;
    }
    public long getCprsTaxHead() {
        return cprsTaxHead;
    }
    public long getCprDiscountHead() {
        return cprDiscountHead;
    }
    public String getVoucherFingerMust() {
        return voucherFingerMust;
    }
    public int getMinFinCapture() {
        return minFinCapture;
    }
    public long getCprsBuyerHead() {
        return cprsBuyerHead;
    }
    public String getCprneftdualAuth() {
        return cprneftdualAuth;
    }
    public long getCprcslesshead() {
        return cprcslesshead;
    }
    public void setCprcslesshead(long cprcslesshead) {
        this.cprcslesshead = cprcslesshead;
    }

    public String getSfdIntonoverduePeriod() {
        return sfdIntonoverduePeriod;
    }

    public String getCpr_GSTYN() {
        return cpr_GSTYN;
    }

    public String getCpr_segreegation() {
        return cpr_segreegation;
    }

    public double getCpr_GSTRate() {
        return cpr_GSTRate;
    }

    public double getCpr_SGSTRate() {
        return cpr_SGSTRate;
    }

    public double getCpr_IGSTRate() {
        return cpr_IGSTRate;
    }

    public long getCpr_SGSTHead() {
        return cpr_SGSTHead;
    }

    public long getCpr_IGSTHead() {
        return cpr_IGSTHead;
    }

    public void setCpr_GSTYN(String cpr_GSTYN) {
        this.cpr_GSTYN = cpr_GSTYN;
    }

    public String getCpr_ChargeGstInclude() {
        return cpr_ChargeGstInclude;
    }

    public long getCpr_GSTHead() {
        return cpr_GSTHead;
    }

    public long getCpr_GSTNettingHead() {
        return cpr_GSTNettingHead;
    }

    public String getCpr_GSTNettingBranchCode() {
        return cpr_GSTNettingBranchCode;
    }

    public double getCpr_CGSTRate() {
        return cpr_CGSTRate;
    }

    public long getCpr_CGSTHead() {
        return cpr_CGSTHead;
    }

    public double getCpr_gstRevChr() {
        return cpr_gstRevChr;
    }

    public long getCpr_gstRevhd() {
        return cpr_gstRevhd;
    }

    public double getCpr_gstcompogsnChr() {
        return cpr_gstcompogsnChr;
    }

    public long getCpr_gstcompogsnhd() {
        return cpr_gstcompogsnhd;
    }

    public long getCpr_tdshd() {
        return cpr_tdshd;
    }

    public long getCpr_ldincomehd() {
        return cpr_ldincomehd;
    }

    public long getCpr_InputSGSTHead() {
        return cpr_InputSGSTHead;
    }

    public long getCpr_InputCGSTHead() {
        return cpr_InputCGSTHead;
    }

    public long getCpr_InputIGSTHead() {
        return cpr_InputIGSTHead;
    }

    public long getCpr_InputrevChrHead() {
        return cpr_InputrevChrHead;
    }

    public double getGstTdsAppAmt() {
        return gstTdsAppAmt;
    }

    public double getGstTdsPerc() {
        return gstTdsPerc;
    }

    public long getGstTdsHead() {
        return gstTdsHead;
    }

    public long getLiabHead() {
        return liabHead;
    }

    public void setLiabHead(long liabHead) {
        this.liabHead = liabHead;
    }

    public long getRevenueHead() {
        return revenueHead;
    }

    public void setRevenueHead(long revenueHead) {
        this.revenueHead = revenueHead;
    }

    public long getGoodsinTransit() {
        return goodsinTransit;
    }

    public void setGoodsinTransit(long goodsinTransit) {
        this.goodsinTransit = goodsinTransit;
    }

    public long getAdvanceGST() {
        return advanceGST;
    }

    public void setAdvanceGST(long advanceGST) {
        this.advanceGST = advanceGST;
    }

    public double getCpr_CompositonRate() {
        return cpr_CompositonRate;
    }

    public int getFundReq_startDay() {
        return fundReq_startDay;
    }

    public int getFundReq_endDay() {
        return fundReq_endDay;
    }

    public int getCpr_bankhead() {
        return cpr_bankhead;
    }

    public int getCpr_cashhead() {
        return cpr_cashhead;
    }

    public String getCpr_cenLimitAcc() {
        return cpr_cenLimitAcc;
    }

    public String getCpr_cenLimitIFSC() {
        return cpr_cenLimitIFSC;
    }

    public String getCprsoactivate() {
        return cprsoactivate;
    }

    public String getCpr_glheaddisplay() {
        return cpr_glheaddisplay;
    }

    public String getCpr_budgetreq() {
        return cpr_budgetreq;
    }

    public String getCpr_budgetinttrs() {
        return cpr_budgetinttrs;
    }

    public int getCpr_chequehead() {
        return cpr_chequehead;
    }

    public String getAuth_reqd() {
        return auth_reqd;
    }

    public String getPackingSlipInSI() {
        return packingSlipInSI;
    }

    public String getRevChrSeparate() {
        return revChrSeparate;
    }

    public String getVenderChangeatPI() {
        return venderChangeatPI;
    }

    public String getChqValidate() {
        return chqValidate;
    }
    public String getInsPolicyNo() {
        return insPolicyNo;
    }
    public String getTcsRecHead() {
        return tcsRecHead;
    }
    public String getRoundOffHead() {
        return roundOffHead;
    }
    public void setRoundOffHead(String roundOffHead) {
        this.roundOffHead = roundOffHead;
    }
    public String getHoBranch() {
        return hoBranch;
    }
    public String getScrapeHead() {
        return scrapeHead;
    }
    public String getBgtBEsameRE() {
        return bgtBEsameRE;
    }
    public String getBudgetCheck() {
        return budgetCheck;
    }
    public String getloccheck() {
        return loccheck;
    }

}

