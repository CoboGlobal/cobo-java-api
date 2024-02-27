# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).

## [v0.76] (2024-02-28)
[v0.76]:  https://github.com/CoboGlobal/cobo-java-api/compare/v0.75...v0.76
### Changed
- Add New Params: Add new parameter 'extra_parameters' for API mpc_speedup_transaction and mpc_drop_transaction. https://github.com/CoboGlobal/cobo-java-api/pull/131

## [v0.75] (2024-01-12)
[v0.75]:  https://github.com/CoboGlobal/cobo-java-api/compare/v0.74...v0.75
### Changed
- Add New Params: Add return value parameter `locked` in API listSpendable for MPC Wallet. https://github.com/CoboGlobal/cobo-java-api/pull/127

## [v0.74] (2024-01-02)
[v0.74]:  https://github.com/CoboGlobal/cobo-java-api/compare/v0.73...v0.74
### Changed
- Add New Params: Add return value parameter `dustThreshold` for API getSupportedCoins and getWalletSupportedCoins for MPC Wallet. https://github.com/CoboGlobal/cobo-java-api/pull/122

## [v0.73] (2023-12-29)
[v0.73]:  https://github.com/CoboGlobal/cobo-java-api/compare/v0.72...v0.73
### Added
- Add code example for splitting satoshis. https://github.com/CoboGlobal/cobo-java-api/pull/118

## [v0.72] (2023-12-29)
[v0.72]:  https://github.com/CoboGlobal/cobo-java-api/compare/v0.71...v0.72
### Added
- Add New API: Add coin_info API for MPC Wallet. https://github.com/CoboGlobal/cobo-java-api/pull/119

## [v0.71] (2023-12-29)
[v0.71]:  https://github.com/CoboGlobal/cobo-java-api/compare/v0.70...v0.71
### Added
- Add New API: Add release satoshis API for MPC Wallet. https://github.com/CoboGlobal/cobo-java-api/pull/115

## [v0.70] (2023-12-28)
[v0.70]:  https://github.com/CoboGlobal/cobo-java-api/compare/v0.69...v0.70
### Added
- Add New API: Add release satoshis API for MPC Wallet. https://github.com/CoboGlobal/cobo-java-api/pull/115

## [v0.69] (2023-12-27)
[v0.69]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.68...v0.69
### Changed
- Add New API: Add APIs for Gas Station. https://github.com/CoboGlobal/cobo-java-api/pull/111

## [v0.68] (2023-12-21)
[v0.68]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.67...v0.68
### Changed
- Add New Params: Add parameter `amount` for API coin_info for Custodial Wallet. https://github.com/CoboGlobal/cobo-java-api/pull/109

## [v0.67] (2023-12-15)
[v0.67]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.66...v0.67
### Changed
- Update testcase.

## [v0.66] (2023-12-13)
[v0.66]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.65...v0.66
### Added
- Add New Params: Add parameter `txid` for API transactions_by_time_ex. https://github.com/CoboGlobal/cobo-java-api/pull/106

## [v0.65] (2023-12-07)
[v0.65]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.64...v0.65
### Added
- Add New API: Add get_max_send_amount API for MPC Wallet. https://github.com/CoboGlobal/cobo-java-api/pull/103

## [v0.64] (2023-11-08)
[v0.64]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.63...v0.64
### Added
- Add New API: Add transactions_by_time_ex API for Custodial Wallet. https://github.com/CoboGlobal/cobo-java-api/pull/97

## [v0.63] (2023-10-26)
[v0.63]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.62...v0.63
### Added
- Add New API: MPC Wallet add Update Address Description API. https://github.com/CoboGlobal/cobo-java-api/pull/95
### Changed
- Add New Params: Custodial Wallet New Withdraw Request and MPC Wallet Create Transaction API add remark param. https://github.com/CoboGlobal/cobo-java-api/pull/93

## [v0.62] (2023-09-05)
[v0.62]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.61...v0.62

## [v0.61] (2023-08-03)
[v0.61]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.60...v0.61

### Changed
- Fix old eckey may init fail. https://github.com/CoboGlobal/cobo-java-api/pull/87

## [v0.60] (2023-07-31)
[v0.60]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.59...v0.60

### Changed
- Fix signature issue on JDK 17. https://github.com/CoboGlobal/cobo-java-api/pull/85

## [v0.59] (2023-07-27)
[v0.59]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.58...v0.59

### Changed
- Add API to get result of API signMessage. https://github.com/CoboGlobal/cobo-java-api/pull/82

## [v0.58] (2023-07-25)
[v0.58]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.57...v0.58

### Changed
- Add signature field in the response of get transactions API. https://github.com/CoboGlobal/cobo-java-api/pull/80

## [v0.57] (2023-07-20)
[v0.57]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.56...v0.57

### Changed
- Add API to list MPC TSS Node info. https://github.com/CoboGlobal/cobo-java-api/pull/78

## [v0.56] (2023-06-01)
[v0.56]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.55...v0.56

### Changed
- Standard Wallet GetOrgInfo release absEstimateFeeUsd. https://github.com/CoboGlobal/cobo-java-api/pull/74

## [v0.55] (2023-05-23)
[v0.55]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.54...v0.55

### Changed
- Support fee amount for MPC UTXO model. https://github.com/CoboGlobal/cobo-java-api/pull/70

## [v0.54] (2023-05-05)
[v0.54]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.53...v0.54

### Changed
- Add request created time in transaction detail. https://github.com/CoboGlobal/cobo-java-api/pull/68

## [v0.53] (2023-04-25)
[v0.53]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.52...v0.53

### Changed
- Add query auth statement status API. https://github.com/CoboGlobal/cobo-java-api/pull/66

## [v0.52] (2023-04-20)
[v0.52]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.51...v0.52

### Changed
- Add approval process in mpc transaction info. https://github.com/CoboGlobal/cobo-java-api/pull/61
- Adjust parameter order of MPCClient.create_transaction(). https://github.com/CoboGlobal/cobo-java-api/pull/63

## [v0.51] (2023-04-19)
[v0.51]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.50...v0.51

### Changed
- Add Callback retry API. https://github.com/CoboGlobal/cobo-java-api/pull/62

## [v0.50] (2023-04-18)
[v0.50]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.49...v0.50

### Changed
- Add standard wallet release get_supported_coins api. https://github.com/CoboGlobal/cobo-java-api/pull/60

## [v0.49] (2023-04-12)
[v0.49]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.48...v0.49

### Changed
- Add Get standard tx by request_ids. https://github.com/CoboGlobal/cobo-java-api/pull/54
- Update Client. https://github.com/CoboGlobal/cobo-java-api/pull/57

## [v0.48] (2023-04-10)
[v0.48]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.47...v0.48

### Changed
- Update request nonce. https://github.com/CoboGlobal/cobo-java-api/pull/55

## [v0.47] (2023-03-13)
[v0.47]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.46...v0.47

### Changed
- Update MPC wallet SaaS api. https://github.com/CoboGlobal/cobo-java-api/pull/51

## [v0.46] (2023-03-03)
[v0.46]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.45...v0.46

### Changed
- Add MPC wallet supported coins api. https://github.com/CoboGlobal/cobo-java-api/pull/49

## [v0.45] (2023-02-16)
[v0.45]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.44...v0.45

### Changed
- Update MPC wallet SaaS api. https://github.com/CoboGlobal/cobo-java-api/pull/45
- Update Web3 wallet api. https://github.com/CoboGlobal/cobo-java-api/pull/45

## [v0.44] (2023-01-30)
[v0.44]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.43...v0.44

### Changed
- Update web3 wallet query transaction api. https://github.com/CoboGlobal/cobo-java-api/pull/43

## [v0.43] (2023-01-16)
[v0.43]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.42...v0.43

### Changed
- Mpc release fund collection demo. https://github.com/CoboGlobal/cobo-java-api/pull/37
- Add http timeout config. https://github.com/CoboGlobal/cobo-java-api/pull/40
- Add callback demo testdata. https://github.com/CoboGlobal/cobo-java-api/pull/41

## [v0.42] (2022-12-29)
[v0.42]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.41...v0.42

### Changed
- Update MPC wallet estimateFee api. https://github.com/CoboGlobal/cobo-java-api/pull/35, https://github.com/CoboGlobal/cobo-java-api/pull/36

## [v0.41] (2022-12-23)
[v0.41]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.40...v0.41

### Changed
- Update MPC wallet SaaS api. https://github.com/CoboGlobal/cobo-java-api/pull/24, https://github.com/CoboGlobal/cobo-java-api/pull/25, https://github.com/CoboGlobal/cobo-java-api/pull/26, https://github.com/CoboGlobal/cobo-java-api/pull/27, https://github.com/CoboGlobal/cobo-java-api/pull/28, https://github.com/CoboGlobal/cobo-java-api/pull/29, https://github.com/CoboGlobal/cobo-java-api/pull/30, https://github.com/CoboGlobal/cobo-java-api/pull/31, https://github.com/CoboGlobal/cobo-java-api/pull/32


## [v0.40] (2022-11-25)
[v0.40]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.39...v0.40

### Changed
- Update Web3 wallet transaction api . https://github.com/CoboGlobal/cobo-java-api/pull/22


## [v0.39] (2022-11-18)
[v0.39]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.38...v0.39

### Changed
- Update MPC wallet generate addresses SaaS api. https://github.com/CoboGlobal/cobo-java-api/pull/18


## [v0.38] (2022-11-17)
[v0.38]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.37...v0.38

### Added
- Support MPC wallet SaaS api. https://github.com/CoboGlobal/cobo-java-api/pull/15, https://github.com/CoboGlobal/cobo-java-api/pull/16, https://github.com/CoboGlobal/cobo-java-api/pull/17

## [v0.37] (2022-10-25)
[v0.37]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.36...v0.37

### Fixed
- Update Web3 wallet withdraw and contract amount type.  https://github.com/CoboGlobal/cobo-java-api/pull/14

## [v0.36] (2022-10-21)
[v0.36]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.33...v0.36

### Fixed
- Optimizate Web3 wallet SaaS api variable naming.  https://github.com/CoboGlobal/cobo-java-api/pull/12, https://github.com/CoboGlobal/cobo-java-api/pull/13


## [v0.33] (2022-10-17)
[v0.33]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.32...v0.33

### Added
- release Web3 wallet SaaS api sdk.  https://github.com/CoboGlobal/cobo-java-api/pull/10, https://github.com/CoboGlobal/cobo-java-api/pull/11

## [v0.32] (2022-07-15)
[v0.32]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.31...v0.32

### Added
- The receiving address is able to support ascending order or descending order queries.  https://github.com/CoboGlobal/cobo-java-api/pull/9, https://github.com/CoboGlobal/cobo-java-api/pull/8


## [v0.31] (2022-07-11)
[v0.31]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.30...v0.31

### Added 
- The receiving address list supports paging queries.  https://github.com/CoboGlobal/cobo-java-api/pull/6


## [v0.30] (2022-06-27)
[v0.30]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.29...v0.30

### Added 
- Transaction records can be searched using TXID.  https://github.com/CoboGlobal/cobo-java-api/pull/5


## [v0.29] (2022-05-16)
[v0.29]: https://github.com/CoboGlobal/cobo-java-api/compare/v0.28...v0.29

### Fixed
- Solve part of the interface due to the newly added return field: minimum_deposit_threshold causes it to not break through issue.  https://github.com/CoboGlobal/cobo-java-api/pull/2
- Change rewardAmount type from int to long.  https://github.com/CoboGlobal/cobo-java-api/pull/3


