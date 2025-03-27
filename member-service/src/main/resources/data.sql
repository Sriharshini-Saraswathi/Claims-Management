INSERT INTO `member` (`member_id`, `age`, `gender`, `member_name`, `phone_number`, `salary`) VALUES ('101', '21', 'male', 'john', '9123456789', '25000');
INSERT INTO `member` (`member_id`, `age`, `gender`, `member_name`, `phone_number`, `salary`) VALUES ('102', '22', 'male', 'james', '9013345678', '26000');
INSERT INTO `member` (`member_id`, `age`, `gender`, `member_name`, `phone_number`, `salary`) VALUES ('103', '23', 'female', 'rachel', '9123456789', '28000');

INSERT INTO `member_premium` (`mp_id`, `charges`, `due_amount`, `due_date`, `member_id`, `paid_date`, `policy_id`) VALUES ('1', '0', '3000', '2021-02-14', '101', '2021-03-15', '1001');
INSERT INTO `member_premium` (`mp_id`, `charges`, `due_amount`, `due_date`, `member_id`, `paid_date`, `policy_id`) VALUES ('2', '0', '4000', '2021-03-05', '102', '2021-03-20', '1002');
INSERT INTO `member_premium` (`mp_id`, `charges`, `due_amount`, `due_date`, `member_id`, `paid_date`, `policy_id`) VALUES ('3', '0', '5000', '2021-03-10', '101', '2021-03-25', '1002');

