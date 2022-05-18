package com.cgi.bank.controller;
class XFAField {
        String fieldName;
        String toolTip;
        String pdfObjRef;
        String value;

        public XFAField(String fieldName, String toolTip, String pdfObjRef) {
            this.fieldName = fieldName;
            this.toolTip = toolTip;
            this.pdfObjRef = pdfObjRef;
        }

        @Override
        public String toString() {
            return "XFAField{" +
                    "fieldName='" + fieldName + '\'' +
                    ", toolTip='" + toolTip + '\'' +
                    ", pdfObjRef='" + pdfObjRef + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }