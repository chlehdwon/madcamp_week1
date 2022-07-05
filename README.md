# <img src="https://user-images.githubusercontent.com/68576681/177258571-64e4855d-bdca-4335-b221-e23d54708cbe.jpg" width="30" height="30"> 몰입스타그램
> 2분반 1주차(2022.06.29~07.05) By 김아나스타시야, 최동원

# Table Of Contents
* [Project Summary](#project-summary)
* [Developer Information](#developer-information)
* [Development Environment](#development-environment)
* [Application Information](#application-information)
***

# Project Summary
* 분반 사람들과 소통할 수 있는 Instagram 컨셉의 어플리케이션입니다
* json 파일을 통해 연락처를 불러와 프로필을 볼 수 있습니다
* 갤러리 사진을 가져와 좋아요 및 저장을 할 수 있습니다
* 각자의 계정을 통해 서로에게 message를 보낼 수 있습니다
***

# Developer Information
* [김아나스타시야](https://github.com/anista13) (부산대학교 정보컴퓨터공학과) 
* [최동원](https://github.com/chlehdwon) (KAIST 전기및전자공학부) 
***

# Development Environment
* OS: Android (compileSdk: 30)
* Language: Kotlin
* IDE: Android Studio
* Target Device: Galaxy S7 (Android 11)
***

# Application Information
## 0. Login & SignUp

<img src="https://user-images.githubusercontent.com/68576681/177273659-f9427d7f-33de-47d6-9ed2-6c4a791f6416.gif" width="200" height="400">  <img src="https://user-images.githubusercontent.com/68576681/177275755-e7c8f0ad-66c0-4bc3-b695-47066ea39029.jpg" width="200" height="400">  <img src="https://user-images.githubusercontent.com/68576681/177275760-c971c2db-e492-48c9-afd7-e67f9eafae38.jpg" width="200" height="400">
### Major features
* 이메일과 비밀번호를 입력받아 로그인을 할 수 있습니다
* 계정이 없을 시, SignUp을 통해 계정을 생성할 수 있습니다
  * 이메일의 형식으로 작성해주어야 합니다
  * 비밀번호는 8자 이상이어야 합니다
  * 잘못된 형식을 입력할 시 Toast 메세지가 나오게 됩니다

### Technology Used
* Firebase를 사용하여 모든 유저들의 정보를 서버에 저장해놓았습니다
* 따라서 다른 기기에서도 동일한 ID로 로그인 할 수 있습니다

## 1. Tab1 - 연락처

<img src="https://user-images.githubusercontent.com/68576681/177273675-c6d1120a-2c9f-4ebc-a1ac-f01f4c3a6b2f.gif" width="200" height="400">  <img src="https://user-images.githubusercontent.com/68576681/177277727-53a7753e-7cbe-4dd7-89c3-b4389ec81eac.jpg" width="200" height="400">  <img src="https://user-images.githubusercontent.com/68576681/177277729-40e3eee9-9d14-4c35-bf74-8bb32100a94b.jpg" width="200" height="400">  <img src="https://user-images.githubusercontent.com/68576681/177277735-9118e859-c626-4971-b0d5-b966ea07ce7b.jpg" width="200" height="400"> 
### Major features
* JSON 파일을 읽어 연락처를 띄울 수 있습니다
* 각 연락처 터치시 그 사람의 프로필을 볼 수 있습니다
  * JSON에서 불러온 이름, 전화번호, 사진, 프로필을 확인할 수 있습니다 
  * CALL 버튼을 누르면 전화창을 띄워줍니다
    * 화면만 띄워줍니다
    * X 버튼을 눌러 다시 돌아올 수 있습니다
   * MESSAGE 버튼을 누르면 Tab3 화면으로 이동합니다
* 화면상단에는 자신의 프로필인 MyCard를 볼 수 있습니다
  * 2022 MADCAMP를 터치시 몰입캠프의 정보를 확인할 수 있습니다
  
### Technology Used
* AssetManager을 사용해 json file을 읽을 수 있습니다
* Recycler View를 이용해 인물정보를 보여줍니다
* NestedScrollView를 사용해 모든 요소들이 같이 움직일 수 있도록 하였습니다
* Viewer의 item을 터치시, adapter에서 Dialog를 띄워 추가 프로필을 확인할 수 있습니다
* MyCard 터치시, fragment에서 FragmentDialog를 띄워 추가 프로필을 확인할 수 있습니다

## 2. Tab2 - 갤러리

<img src="https://user-images.githubusercontent.com/68576681/177276000-107f4dfc-96c5-4ac8-b19d-7333732a7ed4.gif" width="200" height="400">  <img src="https://user-images.githubusercontent.com/68576681/177277676-1e837306-c43c-4305-a5bd-d5d8fca9aedf.jpg" width="200" height="400"> <img src="https://user-images.githubusercontent.com/68576681/177277682-dd60dac1-7654-4e10-a5f4-90a5f91bb9ae.jpg" width="200" height="400">  <img src="https://user-images.githubusercontent.com/68576681/177277684-f33ba12b-7e3d-4b5b-8509-39c6c7353089.jpg" width="200" height="400"> 
### Major features
* 갤러리에서 이미지를 불러와 사진을 볼 수 있습니다
  * 터치시 해당 이미지를 인스타 게시글 스타일로 볼 수 있습니다
  * 하단 좋아요, 저장 버튼을 터치하여 애니메이션 및 Toast 메세지를 확인할 
  * DM 메세지를 터치하여 메인화면으로 돌아갈 수 있습니다

### Technology Used
* Recycler View에 GridLayoutManager을 사용하여 한 줄에 3개씩 사진을 보여줍니다
* com.jackandphantom.android:androidlikebutton:1.2.0을 사용하여 버튼 애니메이션을 구현하였습니다
* NestedScrollView를 사용해 모든 요소들이 같이 움직일 수 있도록 하였습니다

## 3. Tab3 - Direct Message

<img src="https://user-images.githubusercontent.com/68576681/177273474-0471dd5e-8ff1-4517-a97a-fd411e3ca207.gif" width="200" height="400">

### Major features
* 자신을 제외한 사용자들을 띄웁니다
* 사용자 터치 시 그 사용자와 채팅을 할 수 있습니다
* Login후에도 메뉴에서 Logout을 통해 Login으로 언제든 돌아올 수 있습니다

### Technology Used
* Recycler View를 이용해 사용자 정보를 보여줍니다
* Firebase를 통해 사용자들이 보낸 메세지들을 서버에 모두 저장합니다
* senderID와 userID를 통해 각 사용자에 해당하는 메세지들을 받아올 수 있습니다
* ValueEventListener을 통해 변경사항이 생길 시 창을 업데이트 해줍니다

## 4. Future Work(언젠가)
* json 파일이 아닌 Firebase와 연동하여 Tab1과 Tab3가 자동으로 연동될 예정입니다
* Tab1에서 사용자의 정보 및 사진을 업데이트 할 수 있게 할 예정입니다
* Tab2에서 DM 버튼 터치시 Tab3로 이동되게 업데이트 할 예정입니다
* 계정을 삭제하는 기능을 구현할 예정입니다
