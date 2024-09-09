//package com.example.resapis.controller;
//
//import com.example.resapis.entities.UserEntity;
//import com.example.resapis.model.UserModel;
//import com.example.resapis.services.UserService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.*;
////
////@RestController
////@RequestMapping("/user")
////public class UserController {
////
////private Map<Long, UserModel> userList= new HashMap<>();
////
////    @PostMapping("/createUser")
////    public String createUser(@RequestBody UserModel userModel) {
////        userList.put(userModel.getId(), userModel);
////        return "Success Created User";
////    }
////
////
////    @GetMapping("/getAllUsers")
////    public List<UserModel> getAllUsers() {
////        return new ArrayList<>(userList.values());
////    }
////
////    @GetMapping("/getUserById/{userId}")
////    public UserModel getUserById(@PathVariable Long userId) {
////        return userList.get(userId);
////    }
////
////
////    @PutMapping("/editUserById/{userId}")
////    public UserModel editUserById(@PathVariable Long userId, @RequestBody UserModel userModel) {
////        return userList.put(userId,userModel);
////    }
////
////
////    @DeleteMapping("/deleteUserById/{userId}")
////    public String deleteUserById(@PathVariable("userId") Long userId){
////        userList.remove(userId);
////        return "successfully deleted user";
////
////    }
////}
//
//
//
//
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//   private UserService userService;
//
//    @PostMapping("/createUser")
//    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
//        try {
//            userEntity.setDate(LocalDateTime.now());
//            userService.saveUser(userEntity);
//            return new ResponseEntity<>(userEntity, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//    }
//
//
//    @GetMapping("/getAllUsers")
//    public ResponseEntity<?> getAllUsers() {
//        List<UserEntity> allUsers=userService.getAllUser();
//        if(allUsers != null && !allUsers.isEmpty()){
//            return new ResponseEntity<>(allUsers,HttpStatus.OK);
//        }else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//    }
//
//    @GetMapping("/getUserById/{userId}")
//    public ResponseEntity<UserEntity> getUserById(@PathVariable ObjectId userId) {
//        Optional<UserEntity> userEntity = userService.getUserById(userId);
//        return userEntity.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//
//    }
//
//
//    @PutMapping("/editUserById/{userId}")
//    public ResponseEntity<?> editUserById(@PathVariable ObjectId userId, @RequestBody UserEntity newUserEntity) {
//
//        UserEntity old = userService.getUserById(userId).orElse(null);
//
//        if (old != null) {
//            old.setName(newUserEntity.getName() != null && !newUserEntity.getName().isEmpty() ? newUserEntity.getName() : old.getName());
//            old.setAge(newUserEntity.getAge() == 0 ? newUserEntity.getAge() : old.getAge());
//            userService.saveUser(old);
//            return new ResponseEntity<>(old,HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
//        }
//
//
//
//    }
//
//
//    @DeleteMapping("/deleteUserById/{userId}")
//    public ResponseEntity<?> deleteUserById(@PathVariable("userId") ObjectId userId) {
//        userService.deleteById(userId);
//      return new  ResponseEntity<>("successfully Deleted User",HttpStatus.OK);
//
//
//
//    }
//
//
//}
