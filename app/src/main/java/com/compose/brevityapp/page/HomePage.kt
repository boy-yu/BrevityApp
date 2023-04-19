package com.compose.brevityapp.page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.brevityapp.R
import com.compose.brevityapp.model.ImageItem
import com.compose.brevityapp.ui.theme.*


val bloomBannerList = listOf(
    ImageItem("Desert chic", R.drawable.desert_chic),
    ImageItem("Tiny terrariums", R.drawable.tiny_terrariums),
    ImageItem("Jungle Vibes", R.drawable.jungle_vibes)
)

val bloomInfoList = listOf(
    ImageItem("Monster", R.drawable.monstera),
    ImageItem("Maguelonne", R.drawable.aglaonema),
    ImageItem("Peace lily", R.drawable.peace_lily),
    ImageItem("Fiddle leaf tree", R.drawable.fiddle_leaf),
    ImageItem("Desert chic", R.drawable.desert_chic),
    ImageItem("Tiny terrariums", R.drawable.tiny_terrariums),
    ImageItem("Jungle Vibes", R.drawable.jungle_vibes)
)

val navList = listOf(
    ImageItem("Home", R.drawable.ic_home),
    ImageItem("Favorites", R.drawable.ic_favorite_border),
    ImageItem("Profile", R.drawable.ic_account_circle),
    ImageItem("Cart", R.drawable.ic_shopping_cart)
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePage() {
    Scaffold(bottomBar = {
        BottomBar()
    }) {
        Column(
            Modifier
                .fillMaxSize()
                .background(White)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(Modifier.height(30.dp))
            SearchBar()
            BloomRowBanner()
            BloomInfoList()
        }
    }
}

//region 底部导航栏
@Composable
fun BottomBar() {
    BottomAppBar(
        Modifier
            .fillMaxWidth()
            .height(60.dp),
        backgroundColor = Pink100
    ) {
        navList.forEach {
            BottomNavigationItem(
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        painterResource(id = it.resId),
                        contentDescription = "",
                        Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(it.name, style = caption, color = gray)
                },
                selected = ("Home" == it.name)//看是否选中这个
            )
        }
    }
}
//endregion

//region 设置搜索栏
@Composable
fun SearchBar() {
    Box {
        TextField(
            value = "", onValueChange = {}, modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(4.dp))//设置阴影
                .border(BorderStroke(1.dp, Color.Black)),//设置圆角
            //设置首图标
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.ic_search)),
                    contentDescription = "搜索",
                    Modifier.size(18.dp)
                )
            },
            //设置提示内容
            placeholder = {
                Text("Search", style = body1, color = gray)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = White,
                focusedBorderColor = White,//选中时背景颜色
                unfocusedBorderColor = White,//未选中时背景颜色
            )
        )
    }
}
//endregion

//region 卡片栏
@Composable
fun BloomRowBanner() {
    Column {
        Box(Modifier.fillMaxWidth()) {
            Text(
                text = "Browse themes",
                style = h1,
                color = gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 30.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(Modifier.height(136.dp)) {
            items(bloomBannerList.size) {
                if (it != 0) {
                    //让每个子组件间距8dp
                    Spacer(Modifier.width(8.dp))
                }
                PlantCard(bloomBannerList[it])
            }
        }
    }
}
//endregion

//region 卡片设置
@Composable
fun PlantCard(plant: ImageItem) {
    Card(
        modifier = Modifier
            .size(136.dp)//卡片大小
            .clip(RoundedCornerShape(4.dp))//卡片圆角
    ) {
        Column {
            Image(
                painter = painterResource(id = plant.resId),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = plant.name,
                    style = h2,
                    color = gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                )
            }

        }
    }
}
//endregion

//region 选择卡片
@Composable
fun BloomInfoList() {
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween//两边对齐
        ) {
            Text(
                text = "Design your home garden",
                style = h1,
                color = gray,
                modifier = Modifier.paddingFromBaseline(top = 40.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_filter_list),
                contentDescription = "icon",
                modifier = Modifier
                    .size(24.dp)
                    .padding(top = 24.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(bottom = 54.dp)
        ) {
            items(bloomInfoList.size) {
                //设置卡片间距
                if (it != 0) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
                DesignCard(bloomInfoList[it])
            }
        }
    }
}
//endregion

//region 选择卡片
@Composable
fun DesignCard(plant: ImageItem) {
    Row(Modifier.fillMaxWidth()) {
        Image(
            painterResource(id = plant.resId),
            contentScale = ContentScale.Crop,
            contentDescription = "image",
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column {
                    Text(
                        text = plant.name,
                        style = h2,
                        color = gray,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    Text(text = "This is a description", style = body1, color = gray)
                }
                Checkbox(
                    modifier = Modifier
                        .padding(top = 24.dp)
                        .size(24.dp),
                    checked = false,
                    onCheckedChange = {},
                    colors = CheckboxDefaults.colors(checkmarkColor = White)
                )
            }
            //设置分割线
            Divider(
                color = gray, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                thickness = 0.5.dp
            )
        }
    }
}
//endregion