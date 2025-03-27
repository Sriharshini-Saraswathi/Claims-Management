INSERT INTO `member_policy` (`mpo_id`, `benefit_id`, `cap_amount`, `member_id`, `policy_id`, `subscription_date`, `tenure`) VALUES ('1', '501', '200000', '101', '1001', '2021-10-13', '24');
INSERT INTO `member_policy` (`mpo_id`, `benefit_id`, `cap_amount`, `member_id`, `policy_id`, `subscription_date`, `tenure`) VALUES ('2', '501', '200000', '102', '1001', '2021-10-10', '24');
INSERT INTO `member_policy` (`mpo_id`, `benefit_id`, `cap_amount`, `member_id`, `policy_id`, `subscription_date`, `tenure`) VALUES ('3', '502', '250000', '101', '1002', '2021-10-11', '12');
INSERT INTO `member_policy` (`mpo_id`, `benefit_id`, `cap_amount`, `member_id`, `policy_id`, `subscription_date`, `tenure`) VALUES ('4', '501', '150000', '102', '1002', '2021-08-08', '12');
INSERT INTO `member_policy` (`mpo_id`, `benefit_id`, `cap_amount`, `member_id`, `policy_id`, `subscription_date`, `tenure`) VALUES ('5', '503', '250000', '103', '1003', '2021-09-09', '36');

INSERT INTO `benefits` (`benefit_id`, `benefits_availed`) VALUES ('501', 'free monthly check-up');
INSERT INTO `benefits` (`benefit_id`, `benefits_availed`) VALUES ('502', 'covid-19 coverage');
INSERT INTO `benefits` (`benefit_id`, `benefits_availed`) VALUES ('503', 'tax benefits');

INSERT INTO `policy` (`policy_id`, `benefit_id`, `premium_amount`, `tenure`) VALUES ('1001', '501', '15000', '24');
INSERT INTO `policy` (`policy_id`, `benefit_id`, `premium_amount`, `tenure`) VALUES ('1002', '502', '12000', '12');
INSERT INTO `policy` (`policy_id`, `benefit_id`, `premium_amount`, `tenure`) VALUES ('1003', '503', '10000', '36');
INSERT INTO `policy` (`policy_id`, `benefit_id`, `premium_amount`, `tenure`) VALUES ('1004', '501', '18000', '18');
INSERT INTO `policy` (`policy_id`, `benefit_id`, `premium_amount`, `tenure`) VALUES ('1005', '503', '20000', '20');

INSERT INTO `provider_policy` (`pp_id`, `hospital_id`, `hospital_name`, `location`, `policy_id`) VALUES ('1', '601', 'Kims', 'Hyderabad', '1001');
INSERT INTO `provider_policy` (`pp_id`, `hospital_id`, `hospital_name`, `location`, `policy_id`) VALUES ('2', '602', 'Nims', 'Hyderabad', '1001');
INSERT INTO `provider_policy` (`pp_id`, `hospital_id`, `hospital_name`, `location`, `policy_id`) VALUES ('3', '603', 'Tims', 'Secunderabad', '1002');
INSERT INTO `provider_policy` (`pp_id`, `hospital_id`, `hospital_name`, `location`, `policy_id`) VALUES ('4', '604', 'Osmania', 'Secunderabad', '1003');
