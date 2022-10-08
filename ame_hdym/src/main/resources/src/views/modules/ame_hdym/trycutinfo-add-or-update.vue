<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="ʔǐХѠڅìΨһ" prop="code">
      <el-input v-model="dataForm.code" placeholder="ʔǐХѠڅìΨһ"></el-input>
    </el-form-item>
    <el-form-item label="瀛旂洿寰?" prop="width">
      <el-input v-model="dataForm.width" placeholder="瀛旂洿寰?"></el-input>
    </el-form-item>
    <el-form-item label="" prop="height">
      <el-input v-model="dataForm.height" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="thick">
      <el-input v-model="dataForm.thick" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="鐎涙棁顢?" prop="gap">
      <el-input v-model="dataForm.gap" placeholder="鐎涙棁顢?"></el-input>
    </el-form-item>
    <el-form-item label="" prop="diamter">
      <el-input v-model="dataForm.diamter" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point1x">
      <el-input v-model="dataForm.point1x" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point2x">
      <el-input v-model="dataForm.point2x" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point3x">
      <el-input v-model="dataForm.point3x" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point1y">
      <el-input v-model="dataForm.point1y" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point2y">
      <el-input v-model="dataForm.point2y" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point3y">
      <el-input v-model="dataForm.point3y" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point1z">
      <el-input v-model="dataForm.point1z" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point2z">
      <el-input v-model="dataForm.point2z" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point3z">
      <el-input v-model="dataForm.point3z" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point1a">
      <el-input v-model="dataForm.point1a" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point2a">
      <el-input v-model="dataForm.point2a" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point3a">
      <el-input v-model="dataForm.point3a" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point1b">
      <el-input v-model="dataForm.point1b" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point2b">
      <el-input v-model="dataForm.point2b" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point3b">
      <el-input v-model="dataForm.point3b" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point1c">
      <el-input v-model="dataForm.point1c" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point2c">
      <el-input v-model="dataForm.point2c" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="point3c">
      <el-input v-model="dataForm.point3c" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          code: '',
          width: '',
          height: '',
          thick: '',
          gap: '',
          diamter: '',
          point1x: '',
          point2x: '',
          point3x: '',
          point1y: '',
          point2y: '',
          point3y: '',
          point1z: '',
          point2z: '',
          point3z: '',
          point1a: '',
          point2a: '',
          point3a: '',
          point1b: '',
          point2b: '',
          point3b: '',
          point1c: '',
          point2c: '',
          point3c: '',
          time: ''
        },
        dataRule: {
          code: [
            { required: true, message: 'ʔǐХѠڅìΨһ不能为空', trigger: 'blur' }
          ],
          width: [
            { required: true, message: '瀛旂洿寰?不能为空', trigger: 'blur' }
          ],
          height: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          thick: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          gap: [
            { required: true, message: '鐎涙棁顢?不能为空', trigger: 'blur' }
          ],
          diamter: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point1x: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point2x: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point3x: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point1y: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point2y: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point3y: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point1z: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point2z: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point3z: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point1a: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point2a: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point3a: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point1b: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point2b: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point3b: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point1c: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point2c: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          point3c: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/trycutinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.code = data.trycutinfo.code
                this.dataForm.width = data.trycutinfo.width
                this.dataForm.height = data.trycutinfo.height
                this.dataForm.thick = data.trycutinfo.thick
                this.dataForm.gap = data.trycutinfo.gap
                this.dataForm.diamter = data.trycutinfo.diamter
                this.dataForm.point1x = data.trycutinfo.point1x
                this.dataForm.point2x = data.trycutinfo.point2x
                this.dataForm.point3x = data.trycutinfo.point3x
                this.dataForm.point1y = data.trycutinfo.point1y
                this.dataForm.point2y = data.trycutinfo.point2y
                this.dataForm.point3y = data.trycutinfo.point3y
                this.dataForm.point1z = data.trycutinfo.point1z
                this.dataForm.point2z = data.trycutinfo.point2z
                this.dataForm.point3z = data.trycutinfo.point3z
                this.dataForm.point1a = data.trycutinfo.point1a
                this.dataForm.point2a = data.trycutinfo.point2a
                this.dataForm.point3a = data.trycutinfo.point3a
                this.dataForm.point1b = data.trycutinfo.point1b
                this.dataForm.point2b = data.trycutinfo.point2b
                this.dataForm.point3b = data.trycutinfo.point3b
                this.dataForm.point1c = data.trycutinfo.point1c
                this.dataForm.point2c = data.trycutinfo.point2c
                this.dataForm.point3c = data.trycutinfo.point3c
                this.dataForm.time = data.trycutinfo.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/trycutinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'code': this.dataForm.code,
                'width': this.dataForm.width,
                'height': this.dataForm.height,
                'thick': this.dataForm.thick,
                'gap': this.dataForm.gap,
                'diamter': this.dataForm.diamter,
                'point1x': this.dataForm.point1x,
                'point2x': this.dataForm.point2x,
                'point3x': this.dataForm.point3x,
                'point1y': this.dataForm.point1y,
                'point2y': this.dataForm.point2y,
                'point3y': this.dataForm.point3y,
                'point1z': this.dataForm.point1z,
                'point2z': this.dataForm.point2z,
                'point3z': this.dataForm.point3z,
                'point1a': this.dataForm.point1a,
                'point2a': this.dataForm.point2a,
                'point3a': this.dataForm.point3a,
                'point1b': this.dataForm.point1b,
                'point2b': this.dataForm.point2b,
                'point3b': this.dataForm.point3b,
                'point1c': this.dataForm.point1c,
                'point2c': this.dataForm.point2c,
                'point3c': this.dataForm.point3c,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
