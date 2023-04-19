package com.compose.brevityapp.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.brevityapp.R
import com.compose.brevityapp.ui.theme.*

@Preview(showSystemUi = true)
//region 背景
@Composable
fun WelcomePage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Pink100)
    ) {
        Image(
            painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.ic_light_welcome_bg)),
            contentDescription = "welcome_bg",
            //充满屏幕
            modifier = Modifier.fillMaxSize()
        )
        WelcomeContent()
    }
}
//endregion

//region 背景之外的组件
@Composable
fun WelcomeContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(72.dp))
        LeafImage()//树叶图片
        Spacer(Modifier.height(48.dp))
        WelcomeTitle()
        Spacer(Modifier.height(40.dp))
        WelcomeButtons()
    }
}
//endregion

//region 树叶图片
@Composable
fun LeafImage() {
    Image(
        painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.ic_light_welcome_illos)),
        contentDescription = "树叶图片",
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 88.dp)
    )

}
//endregion

//region 欢迎标题
@Composable
fun WelcomeTitle() {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.ic_light_logo)),
            contentDescription = "welcome_logo",
            Modifier
                .wrapContentSize()
                .height(32.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = "欢迎使用，请登录/注册",
                textAlign = TextAlign.Center,
                style = subtitle,
                color = gray
            )
        }

    }
}
//endregion


//region 登录按钮
@Composable
fun WelcomeButtons() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 16.dp)//设置外边距
                .clip(medium),//设置圆角
            //设置按钮颜色
            colors = ButtonDefaults.buttonColors(Pink900)
        ) {
            Text(text = "登录", style = button, color = White)
        }
        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "注册", style = button, color = Pink900)
    }
}
//endregion