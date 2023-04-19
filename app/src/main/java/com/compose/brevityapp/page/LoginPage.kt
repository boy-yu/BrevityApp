package com.compose.brevityapp.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.brevityapp.ui.theme.*

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginTitle()
        LoginInputBox()
        HintWithUnderline()
        LoginBottom()
    }
}

//region 登录标题
@Composable
fun LoginTitle() {
    Text(
        text = "登录",
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 184.dp, bottom = 16.dp),
        style = h1,
        color = gray,
        textAlign = TextAlign.Center
    )
}
//endregion

//region 账号密码输入框输入框
@Composable
fun LoginInputBox() {
    Column {
        LoginTextField("请输入账号")
        Spacer(Modifier.height(8.dp))
        LoginTextField("请输入密码")
    }
}

//endregion
@Composable
fun LoginTextField(placeHolder: String) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(Small),
        placeholder = {
            Text(text = placeHolder, style = body1, color = gray)
        })
}


//region 登录说明
@Composable
fun HintWithUnderline() {
    Column(modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)) {
        TopText()
        ButtonText()
    }
}

//endregion
@Composable
fun TopText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        //设置两端对齐
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "By Clicking below you agree to our ", style = body2, color = gray)
        Text(
            text = "Ter of Use",
            style = body2,
            color = gray,
            textDecoration = TextDecoration.Underline//添加下划线
        )
        Text(text = " and consent", style = body2, color = gray)

    }
}

@Composable
fun ButtonText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        //设置两端对齐
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "to our ", style = body2, color = gray)
        Text(
            text = "Privacy Policy",
            style = body2,
            color = gray,
            textDecoration = TextDecoration.Underline//添加下划线
        )
    }
}

//region 登录按钮
@Composable
fun LoginBottom() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(medium),//设置圆角
        //设置按钮颜色
        colors = ButtonDefaults.buttonColors(Pink900)
    ) {
        Text(text = "登录", style = button, color = White)
    }
}
//endregion