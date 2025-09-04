# 🤝 贡献指南

感谢你对ColorMatch项目的关注！我们欢迎任何形式的贡献。

## 🎯 贡献方式

### 🐛 报告Bug
- 使用[Bug报告模板](https://github.com/Shinitongge/ColorMatch/issues/new?template=bug_report.md)
- 提供详细的复现步骤
- 包含设备信息和截图

### ✨ 提出功能建议
- 使用[功能请求模板](https://github.com/Shinitongge/ColorMatch/issues/new?template=feature_request.md)
- 描述使用场景和预期效果
- 提供相关的参考资料

### 💻 代码贡献

#### 开发环境设置
1. Fork本仓库
2. 克隆你的Fork
   ```bash
   git clone https://github.com/Shinitongge/ColorMatch.git
   ```
3. 创建功能分支
   ```bash
   git checkout -b feature/your-feature-name
   ```

#### 代码规范
- 遵循[Kotlin编码规范](https://kotlinlang.org/docs/coding-conventions.html)
- 使用有意义的变量和函数名
- 添加必要的注释
- 保持代码简洁和可读性

#### 提交规范
使用约定式提交(Conventional Commits)：

```
类型(范围): 简短描述

详细描述（可选）

相关Issue: #123
```

类型包括：
- `feat`: 新功能
- `fix`: Bug修复
- `docs`: 文档更新
- `style`: 代码格式
- `refactor`: 重构
- `test`: 测试
- `chore`: 构建工具等

示例：
```bash
git commit -m "feat(camera): 添加手动对焦功能

- 实现点击对焦
- 添加对焦指示器
- 优化低光环境下的对焦性能

Fixes #15"
```

#### Pull Request流程
1. 确保你的代码通过所有测试
2. 更新相关文档
3. 创建Pull Request
4. 等待代码审查
5. 根据反馈修改代码

## 🏗️ 项目结构

```
app/src/main/java/com/colormatch/app/
├── data/           # 数据层
│   └── model/      # 数据模型
├── ui/             # UI层
│   ├── camera/     # 相机模块
│   ├── classification/ # 分类模块
│   ├── analysis/   # 分析模块
│   └── gallery/    # 图库模块
└── utils/          # 工具类
```

## 🧪 测试

### 运行测试
```bash
# 单元测试
./gradlew testDebugUnitTest

# UI测试
./gradlew connectedDebugAndroidTest
```

### 测试覆盖率
```bash
./gradlew jacocoTestReport
```

## 📝 文档

### 更新文档
- README.md: 项目概述和使用指南
- CHANGELOG.md: 版本更新记录
- 代码注释: 关键功能的实现说明

### 添加新功能文档
- 在相应的Wiki页面添加使用说明
- 更新API文档
- 添加示例代码

## 🎨 设计规范

### UI/UX指导原则
- 遵循Material Design 3规范
- 保持界面简洁直观
- 注重用户体验一致性
- 支持无障碍访问

### 颜色和字体
- 使用项目定义的主题颜色
- 字体大小和间距保持一致
- 支持深色模式

## 🏷️ 版本发布

### 版本号规则
遵循[语义化版本](https://semver.org/lang/zh-CN/)：
- `MAJOR.MINOR.PATCH` (如 1.2.3)
- 主版本号：不兼容的API修改
- 次版本号：向下兼容的功能性新增
- 修订号：向下兼容的问题修正

### 发布流程
1. 更新版本号和CHANGELOG
2. 创建Release PR
3. 合并后自动发布

## 📞 联系方式

- 📧 Email: your-email@example.com
- 💬 Discussions: [GitHub Discussions](https://github.com/Shinitongge/ColorMatch/discussions)
- 🐛 Issues: [GitHub Issues](https://github.com/Shinitongge/ColorMatch/issues)

## 📄 许可证

通过贡献代码，你同意你的贡献将在[MIT许可证](LICENSE)下发布。

---

再次感谢你的贡献！🎉