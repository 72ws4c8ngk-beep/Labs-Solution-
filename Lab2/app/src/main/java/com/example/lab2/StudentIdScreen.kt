
package com.example.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF0B2545)
private val AndroidGreen = Color(0xFF3DDC84)
private val Background = Color(0xFFF4F7FA)

// Reusable composable
@Composable
fun StudentStat(value: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            color = Navy
        )

        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun StudentIdScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {

        // Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(20.dp)
        ) {
            Text(
                text = "Student ID Card",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 7 - Row and Column",
                color = Color.LightGray
            )
        }

        // Student information card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                modifier = Modifier.padding(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(Navy),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "ST",
                        color = Color.White,
                        fontSize = 22.sp
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "Your Name",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Computer Science",
                        color = Color.Gray
                    )

                    Text(
                        text = "Your Student ID",
                        fontFamily = FontFamily.Monospace
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Surface(
                            color = AndroidGreen,
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Text(
                                text = "Level 4",
                                modifier = Modifier.padding(8.dp),
                                color = Navy
                            )
                        }

                        Surface(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(20.dp)
                        ) {
                            Text(
                                text = "CSHJ",
                                modifier = Modifier.padding(8.dp),
                                color = Navy
                            )
                        }
                    }
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Statistics card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StudentStat("4.42", "GPA")
                StudentStat("78", "Credits")
                StudentStat("Active", "Status")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentIdScreenPreview() {
    MaterialTheme {
        StudentIdScreen()
    }
}
