package com.example.core.common

const val AUTHORIZATION = "Authorization"
const val BEARER = "Bearer "

const val HEAD_QUARTER_USER_LOCATION_ID = -1
// Location Level
const val HQ_LEADER = 0
const val HQ_AND_AREA_LEADER = 1
const val REGION_LEADER = 2
const val DISTRICT_LEADER = 3
const val UNIT = 9
const val STORE_LEADER_AND_SALES_LEADER = 4
const val SALES_CONSULTANT = 5
const val CUSTOM = 6
const val UNKNOWN = -1

// NULL number
const val DEFAULT_CODE_LIMIT = 5
const val NULL_NUMBER = -99
const val NULL_NUMBER_DOUBLE = 00.00
const val NULL_NUMBER_FLOAT = 00.00f

// Bundle Keys
const val BREAK_START_TIME = "BreakTime"
const val NOTIFICATION_TYPE = "NotificationType"
const val NOTIFICATION_DATA = "NotificationData"
const val END_TIME = "EndTime"
const val HRA_ASSOCIATE_OID = "HRAssociateOID"
const val NOTIFICATION_TITLE = "PopupTitle"
const val NOTIFICATION_BODY = "PopupBody"
const val WRAP_ALERT_NOTIFICATION_DATA = "WrapAlertNotificationData"
const val PUSH_KEY_WRAP_ALERT_ID = "WrapAlertId"
const val PUSH_KEY_MDM_EMPLOYEE_ID = "MDMEmployeeId"
const val CUSTOM_SCHEDULE_FILTER_DETAILS="CustomScheduleFilterDetails"
const val CUSTOM_SCHEDULE_SCREEN_SHOWN="custom_schedule_screen_shown"
const val CLOSED_LABEL = "CLOSED"
const val DISCOUNT_CODES = "DISCOUNT_CODES"
const val RESET_GET_CODES="RESET_GET_CODES"
const val SELECTED_CODES = "SELECTED_CODES"
const val SELECTED_PAY_PERIOD = "SELECTED_PAY_PERIOD"
const val MISSED_PUNCH_DATA = "missed_punch_data"
const val SELECTED_COST_CENTER = "SELECTED_COST_CENTER"
const val SIGNATURE_DATA = "SIGNATURE_DATA"

const val PRIVACY_POLICY_LINK = "https://victra.com/mobile-app-privacy-policy/"

const val NO_OF_RETRY = 3

const val BUILD_VARIANT_RELEASE = "release"
const val BUILD_VARIANT_QA = "qa"
const val BUILD_VARIANT_STAGING = "staging"
const val BUILD_VARIANT_STAGING_DEBUG = "stagingdebug"
const val BUILD_VARIANT_QA_DEBUG = "qadebug"
const val BUILD_VARIANT_RELEASE_DEBUG = "releasedebug"
const val BUILD_VARIANT_DEV_RELEASE = "devrelease"
const val BUILD_VARIANT_ENTERPRISE = "enterprise"
const val BUILD_VARIANT_ENTERPRISE_DEBUG_RELEASE = "enterprisedebug"
const val BUILD_VARIANT_ENTERPRISE_DEV_DEBUG = "enterprisedevdebug"

// Time card
const val IN_ENTRY = "In"
const val OUT_ENTRY = "Out"

//HTTP status codes
const val HTTP_STATUS_CODE_208 = 208

// Application Events
const val LOGIN_OUT = 2
const val APP_CLOSED = 4

//Break Type
const val REST_BREAK_TYPE = "RBTY"

const val BEACON_MONITORING_START_TIME = 7
const val BEACON_MONITORING_END_TIME = 23