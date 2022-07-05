# <img src="https://user-images.githubusercontent.com/68576681/177258571-64e4855d-bdca-4335-b221-e23d54708cbe.jpg" width="30" height="30"> 몰입스타그램
> 2분반 1주차(2022.06.29~07.05) By 김아나스타시야, 최동원

# Project Summary
* 분반 사람들과 소통할 수 있는 Instagram 컨셉의 어플리케이션입니다
* json 파일을 통해 연락처를 불러와 프로필을 볼 수 있습니다
* 갤러리 사진을 가져와 좋아요 및 저장을 할 수 있습니다
* 각자의 계정을 통해 서로에게 message를 보낼 수 있습니다
***

# Developer Information
* 김아나스타시야 (부산대학교 정보컴퓨터공학과) 
* 최동원 (KAIST 전기및전자공학부) 
***

# Development Environment
* OS: Android (compileSdk: 30)
* Language: Kotlin
* IDE: Android Studio
* Target Device: Galaxy S7 (Android 11)
***

# Application Information
## 0.Login & SignUp
### Major features
* 이메일과 비밀번호를 입력받아 로그인을 할 수 있습니다
* 계정이 없을 시, SignUp을 통해 계정을 생성할 수 있습니다
  * 이메일의 형식으로 작성해주어야 합니다
  * 비밀번호는 8자 이상이어야 합니다
  * 잘못된 형식을 입력할 시 Toast 메세지가 나오게 됩니다
* Login후에도 메뉴에서 Logout을 통해 Login으로 언제든 돌아올 수 있습니다

### Technology Used
* Firebase를 사용하여 모든 유저들의 정보를 서버에 저장해놓았습니다
* 따라서 다른 기기에서도 동일한 ID로 로그인 할 수 있습니다

## 1.Tab1 - 연락처
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

## 2.Tab2 - 갤러리
### Major features
* 갤러리에서 이미지를 불러와 사진을 볼 수 있습니다
  * 터치시 해당 이미지를 인스타 게시글 스타일로 볼 수 있습니다
  * 하단 좋아요, 저장 버튼을 터치하여 표시할 수 있습니다
  * DM 메세지를 터치하여 메인화면으로 돌아갈 수 있습니다

### Technology Used
* Recycler View에 GridLayoutManager을 사용하여 한 줄에 3개씩 사진을 보여줍니다
* com.jackandphantom.android:androidlikebutton:1.2.0을 사용하여 버튼 애니메이션을 구현하였습니다
* NestedScrollView를 사용해 모든 요소들이 같이 움직일 수 있도록 하였습니다

## 3.Tab3 - Direct Message
### Major features
* 자신을 제외한 사용자들을 띄웁니다
* 사용자 터치 시 그 사용자와 채팅을 할 수 있습니다

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
