<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="èъѠڅ" prop="code">
      <el-input v-model="dataForm.code" placeholder="èъѠڅ"></el-input>
    </el-form-item>
    <el-form-item label="ݸظ˙ֈ" prop="vel">
      <el-input v-model="dataForm.vel" placeholder="ݸظ˙ֈ"></el-input>
    </el-form-item>
    <el-form-item label="ַ֡ת˙" prop="rotvel">
      <el-input v-model="dataForm.rotvel" placeholder="ַ֡ת˙"></el-input>
    </el-form-item>
    <el-form-item label="߬ݸ˙ֈ" prop="fastvel">
      <el-input v-model="dataForm.fastvel" placeholder="߬ݸ˙ֈ"></el-input>
    </el-form-item>
    <el-form-item label="èգɮֈ" prop="deep">
      <el-input v-model="dataForm.deep" placeholder="èգɮֈ"></el-input>
    </el-form-item>
    <el-form-item label="èգưʼλփ" prop="oripos">
      <el-input v-model="dataForm.oripos" placeholder="èգưʼλփ"></el-input>
    </el-form-item>
    <el-form-item label="ѹ݅ѹf" prop="press">
      <el-input v-model="dataForm.press" placeholder="ѹ݅ѹf"></el-input>
    </el-form-item>
    <el-form-item label="ъܢޠ+" prop="dis">
      <el-input v-model="dataForm.dis" placeholder="ъܢޠ+"></el-input>
    </el-form-item>
    <el-form-item label="նߢλփ" prop="pos">
      <el-input v-model="dataForm.pos" placeholder="նߢλփ"></el-input>
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
          vel: '',
          rotvel: '',
          fastvel: '',
          deep: '',
          oripos: '',
          press: '',
          dis: '',
          pos: '',
          time: ''
        },
        dataRule: {
          code: [
            { required: true, message: 'èъѠڅ不能为空', trigger: 'blur' }
          ],
          vel: [
            { required: true, message: 'ݸظ˙ֈ不能为空', trigger: 'blur' }
          ],
          rotvel: [
            { required: true, message: 'ַ֡ת˙不能为空', trigger: 'blur' }
          ],
          fastvel: [
            { required: true, message: '߬ݸ˙ֈ不能为空', trigger: 'blur' }
          ],
          deep: [
            { required: true, message: 'èգɮֈ不能为空', trigger: 'blur' }
          ],
          oripos: [
            { required: true, message: 'èգưʼλփ不能为空', trigger: 'blur' }
          ],
          press: [
            { required: true, message: 'ѹ݅ѹf不能为空', trigger: 'blur' }
          ],
          dis: [
            { required: true, message: 'ъܢޠ+不能为空', trigger: 'blur' }
          ],
          pos: [
            { required: true, message: 'նߢλփ不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/ame_hdym/dpprocess/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.code = data.dpprocess.code
                this.dataForm.vel = data.dpprocess.vel
                this.dataForm.rotvel = data.dpprocess.rotvel
                this.dataForm.fastvel = data.dpprocess.fastvel
                this.dataForm.deep = data.dpprocess.deep
                this.dataForm.oripos = data.dpprocess.oripos
                this.dataForm.press = data.dpprocess.press
                this.dataForm.dis = data.dpprocess.dis
                this.dataForm.pos = data.dpprocess.pos
                this.dataForm.time = data.dpprocess.time
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
              url: this.$http.adornUrl(`/ame_hdym/dpprocess/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'code': this.dataForm.code,
                'vel': this.dataForm.vel,
                'rotvel': this.dataForm.rotvel,
                'fastvel': this.dataForm.fastvel,
                'deep': this.dataForm.deep,
                'oripos': this.dataForm.oripos,
                'press': this.dataForm.press,
                'dis': this.dataForm.dis,
                'pos': this.dataForm.pos,
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
